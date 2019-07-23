package com.fengmi.demo.config;

import com.fengmi.demo.BaseInterceptor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 配置静态资源映射
 **/
//@Configuration
//@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {
    //    @Bean
//    public SecurityInterceptor getSecurityInterceptor() {
//        return new SecurityInterceptor();
//    }
//
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet);
//        servletServletRegistrationBean.addUrlMappings("*.html");
//        servletServletRegistrationBean.addUrlMappings("*.css");
//        servletServletRegistrationBean.addUrlMappings("*.js");
//        servletServletRegistrationBean.addUrlMappings("*.png");
//        servletServletRegistrationBean.addUrlMappings("*.gif");
//        servletServletRegistrationBean.addUrlMappings("*.ico");
//        servletServletRegistrationBean.addUrlMappings("*.jpeg");
//        servletServletRegistrationBean.addUrlMappings("*.jpg");
//        servletServletRegistrationBean.addUrlMappings("*.do");
//        return servletServletRegistrationBean;
//    }
//
//    private class SecurityInterceptor extends HandlerInterceptorAdapter {
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//            System.out.println("preHandle request --" + request.getRequestURI());
//            return true;
//        }
//    }
//
//    //
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
////        //排除配置
////        addInterceptor.excludePathPatterns("/layui/**", "/static/**", "/css/**", "/images/**", "/js/**");
////        //拦截配置
////        addInterceptor.addPathPatterns("/**");
////    }
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/getAllProduct").excludePathPatterns("/static/**");
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
}