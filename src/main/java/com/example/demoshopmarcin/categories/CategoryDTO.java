package com.example.demoshopmarcin.categories;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {

    private Long id;
    private Long parentId;
    private Integer depth;
    private String categoryName;
    private CategoryDTO parentCategory;
    private CategoryState categoryState;

    public String getText() {
        return id + ". " + categoryName;
    }

    public String getParent() {
        return parentId == null ? "#" : parentId.toString();
    }

}
