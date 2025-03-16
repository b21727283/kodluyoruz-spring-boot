package com.mgumussoy.kodluyoruz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class ProductDto {
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
}
