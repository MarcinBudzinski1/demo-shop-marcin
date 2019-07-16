package com.example.demoshopmarcin.categories;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDto {

    private Long id;
    private Long parentId;
    private Integer depth;
    private String categoryName;

}
