package com.example.demoshopmarcin.products;

import com.example.demoshopmarcin.categories.Category;
import lombok.*;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Company company;
    private String ProductName;
    private BigDecimal price;
    private String url;
    private String description;
    @ManyToOne
    private Category category;
}
