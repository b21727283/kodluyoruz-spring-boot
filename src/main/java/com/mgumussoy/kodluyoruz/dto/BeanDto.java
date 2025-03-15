package com.mgumussoy.kodluyoruz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class BeanDto {
    private Long id;
    private String beanName;
    private String beanData;

    public void initialBeanMethod() {
        log.info("initialBeanMethod");
        System.out.println("initialBeanMethod");
    }

    public void destroyBeanMethod() {
        log.info("destroyBeanMethod");
        System.err.println("destroyBeanMethod");
    }
}
