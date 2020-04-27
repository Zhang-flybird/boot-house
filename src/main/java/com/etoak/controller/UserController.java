package com.etoak.controller;

import com.etoak.bean.User;
import com.etoak.commons.CommonResult;
import com.etoak.exception.ParamException;
import com.etoak.exception.UserLoginException;
import com.etoak.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.ACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    //判断用户的激活状态
    private static final int ACTIVE_STATE = 1;
    @Autowired
    UserService userService;

    /**
     * 跳转到注册页面
     * @return
     */
    @GetMapping("/toReg")
    public String toRegPage(){
        return "user/reg";
    }

    /**
     * 注册
     * @param confirmPassword
     * @param user
     * @return
     */
    @PostMapping("/reg")
    public String reg(@RequestParam String confirmPassword, User user){
        //检查两次密码是否一致
        if(!StringUtils.equals(confirmPassword,user.getPassword())){
            throw new ParamException("两次密码不一致");
        }
        userService.addUser(user);
        return "redirect:/user/toReg";
    }

    /**
     * 校验用户名唯一性
     * @param name
     * @return
     */
    @GetMapping("/validateName")
    @ResponseBody
    public String validateName(@RequestParam String name){
        log.info("param name -{}",name);
        User user = userService.queryByName(name);
        return user == null ? "true": "false";
    }

    @GetMapping("/toLogin")
    public String toLogin(){
        return "user/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestParam String name,
                              @RequestParam String password,
                              @RequestParam String code,
                              HttpServletRequest request){
        /**
         * 验证码是否正确
         *
         */
        HttpSession session = request.getSession();
        String sessionCode  =String.valueOf(session.getAttribute("code"));
        if(!StringUtils.equals(code,sessionCode)){
            throw new UserLoginException("验证码错误");
        }
        //根据name查询用户
        User user = userService.queryByName(name);
        if(ObjectUtils.isEmpty(user)){
            log.error("未查询到用户");
            throw new UserLoginException("用户名或密码错误");
        }

        if(user.getState() == ACTIVE_STATE){
            throw new UserLoginException("用户状态异常");
        }

        //MD5加密，执行密码比对
        password = DigestUtils.md5Hex(password);
        if(!StringUtils.equals(password,user.getPassword())){
            log.error("密码错误"); //不要把密码记录在日志中
            throw new UserLoginException("用户名或密码错误");
        }
        //销毁之前的session
        session.invalidate();
        session = request.getSession();

        user.setPassword(null);
        session.setAttribute("user",user);

        return new CommonResult(CommonResult.SUCCESS_CODE,CommonResult.SUCCESS_MSG);
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){

        request.getSession().invalidate();
        return "redirect:/user/toLogin";
    }
}
