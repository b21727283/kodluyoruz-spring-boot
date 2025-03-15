package com.mgumussoy.kodluyoruz.controller;

import com.mgumussoy.kodluyoruz.bean.BeanConfig;
import com.mgumussoy.kodluyoruz.bean.PostConstructExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeanController {

    @Autowired
    BeanConfig beanConfig;

    @Autowired
    PostConstructExample postConstructExample;

    @GetMapping("/bean/beandto")
    @ResponseBody
    public String getBeanDto() {
        return beanConfig.beanDto().toString();
    }

    @GetMapping("/bean/logger")
    @ResponseBody
    public String getBeanLogger() {
        return postConstructExample.helloWorld();
    }
}
