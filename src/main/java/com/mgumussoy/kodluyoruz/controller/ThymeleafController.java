package com.mgumussoy.kodluyoruz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// thymeleaf -> kekik yaprağı
@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    //@ResponseBody
    public String getThymeleaf() {
        return "thymeleaf1";
    }

    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim-1");
        model.addAttribute("key_model2", "Ben modelden geldim-2");
        return "thymeleaf2";
    }

    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim-1");
        return "thymeleaf_file/thymeleaf3";
    }
}
