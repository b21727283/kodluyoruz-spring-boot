package com.mgumussoy.kodluyoruz.tutorials.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConstructExample {

    BeanConfig beanConfig;

    @Autowired
    public PostConstructExample(BeanConfig beanConfig) {
        this.beanConfig = beanConfig;
        beanConfig.logger().info("PostConstructExample Constructor");
    }

    @PostConstruct
    public void init(){
        beanConfig.logger().info("PostConstruct Example");
    }

    public String helloWorld() {
        return "Hello World";
    }

}
