package com.example.demoshopmarcin.categories;

import com.example.demoshopmarcin.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Builder
public class Category extends BaseEntity {

    private String categoryName;
    private Long parentId;
    private Integer depth;

    public Category(Long parentId, String categoryName) {
        this.parentId = parentId;
        this.categoryName = categoryName;
    }
}
