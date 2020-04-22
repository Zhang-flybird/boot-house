package com.etoak.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.builder.ParameterExpression;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ParamException.class)
    public ModelAndView handlerParamException(ParamException e){
        log.error(e.getMessage(),e);
        ModelAndView modelAndView = new ModelAndView();
        //将错误信息添加到request域中
        modelAndView.addObject("error",e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
