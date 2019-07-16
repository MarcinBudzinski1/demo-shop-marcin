package com.example.demoshopmarcin.products;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ProductDto {
    private String companyName;
    private String ProductName;
    private BigDecimal price;
    private String url;
    private String description;
    private Long categoryId;
    private Integer stockAmount;
}
