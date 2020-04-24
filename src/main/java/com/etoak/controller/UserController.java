package com.etoak.controller;

import com.etoak.bean.User;
import com.etoak.exception.ParamException;
import com.etoak.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

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
     * @param confirmpassword
     * @param user
     * @return
     */
    @PostMapping("/reg")
    public String reg(@RequestParam String confirmpassword, User user){
        //检查两次密码是否一致
        if(!StringUtils.equals(confirmpassword,user.getPassword())){
            throw new ParamException("两次密码不一致");
        }
        userService.addUser(user);
        return "redirect:/user/toReg";
    }
}
