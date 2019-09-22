package com.example.config;

import com.example.intercepter.ThreadRenameIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class DemoWebMvcConfig extends WebMvcConfigurationSupport {




    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ThreadRenameIntercepter()).addPathPatterns("/**").excludePathPatterns("/**.css,/**.js,/**.html");
       // WebMvcConfigurer.super.addInterceptors(registry);
    }
 }
