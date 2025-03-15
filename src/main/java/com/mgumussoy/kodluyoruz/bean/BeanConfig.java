package com.mgumussoy.kodluyoruz.bean;

import com.mgumussoy.kodluyoruz.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.logging.Logger;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBeanMethod", destroyMethod = "destroyBeanMethod")
    @Scope("singleton")
    // session, request, prototype
    public BeanDto beanDto() {
        return BeanDto.builder()
                .id(1L)
                .beanName("BeanName")
                .beanData("BeanData")
                .build();
    }

    @Bean
    public Logger logger() {
        return Logger.getLogger(PostConstructExample.class.getName());
    }



}
