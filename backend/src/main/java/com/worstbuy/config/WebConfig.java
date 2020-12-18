package com.worstbuy.config;

import com.worstbuy.interceptor.HeaderTokenInterceptor;
import com.worstbuy.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.worstbuy.controller")
public class WebConfig implements WebMvcConfigurer {
    @Bean
    HttpInterceptor httpInterceptor(){
        return new HttpInterceptor();
    }

    @Bean
    HeaderTokenInterceptor headerTokenInterceptor(){
        return new HeaderTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(httpInterceptor());
//        registry.addInterceptor(headerTokenInterceptor());
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
