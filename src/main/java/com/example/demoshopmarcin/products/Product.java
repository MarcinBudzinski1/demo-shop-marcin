package com.example.demoshopmarcin.products;

import com.example.demoshopmarcin.BaseEntity;
import com.example.demoshopmarcin.categories.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "system_type", discriminatorType = DiscriminatorType.STRING)
public class Product extends BaseEntity {

    private Company company;
    private String ProductName;
    private BigDecimal price;
    private String url;
    private String description;
    @ManyToOne
    private Category category;

}
