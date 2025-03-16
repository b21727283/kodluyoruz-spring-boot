package com.mgumussoy.kodluyoruz.controller;

import com.mgumussoy.kodluyoruz.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// thymeleaf -> kekik yaprağı
@Controller
public class ThymeleafController {

    @GetMapping({"/", "index"})
    public String index() {
        return "index";
    }

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

    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim-1");
        model.addAttribute("key_model2", "Ben modelden geldim-2");
        return "thymeleaf4";
    }

    @GetMapping("/thymeleaf5")
    public String getThymeleaf5ModelObject(Model model) {
        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName("Ürün Adı")
                .productPrice(BigDecimal.valueOf(2500))
                .build();
        model.addAttribute("key_model2", productDto);
        model.addAttribute("key_model1", "text");
        return "thymeleaf5";
    }

    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelObject(Model model) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productPrice(BigDecimal.valueOf(1000))
                .build());
        productDtoList.add(ProductDto
                .builder()
                .productId(2L)
                .productName("Ürün Adı")
                .productPrice(BigDecimal.valueOf(2500))
                .build());
        productDtoList.add(ProductDto
                .builder()
                .productId(3L)
                .productName("Ürün Adı")
                .productPrice(BigDecimal.valueOf(1500))
                .build());
        productDtoList.add(ProductDto
                .builder()
                .productId(4L)
                .productName("Ürün Adı")
                .productPrice(BigDecimal.valueOf(2500))
                .build());

        model.addAttribute("product_list", productDtoList);
        return "thymeleaf6";
    }

    @GetMapping({"/thymeleaf7", "/thymeleaf7/{id}"})
    public String getThymeleaf7ModelObject(Model model, @PathVariable(name = "id", required = false) Long id) {
        model.addAttribute("key_model1", Objects.requireNonNullElse(id, "id bulunamadı"));
        return "thymeleaf7";
    }

    // http://localhost:8080/thymeleaf8?id=5
    @GetMapping("/thymeleaf8")
    public String getThymeleaf8ModelObject(Model model, @RequestParam(name = "id", required = false) Long id) {
        model.addAttribute("key_model1", Objects.requireNonNullElse(id, "id bulunamadı"));
        return "thymeleaf7";
    }


}
