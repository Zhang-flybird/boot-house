package com.etoak.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * 配置支持同步请求发送rest请求的过滤器
 *
 * 将post转成PUT DELETE 请求等
 * 要求：1.表中提交方式必须为POST
 *      2.表单必须有一个隐藏域，name属性是_method,value值是rest请求(put，delete...）
 */
@Configuration
public class RestFilterConfig {

    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> restFilter(){
        FilterRegistrationBean<HiddenHttpMethodFilter> restFilter = new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
        restFilter.addUrlPatterns("/*");
        return restFilter;
    }

}
