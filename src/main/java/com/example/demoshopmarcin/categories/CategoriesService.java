package com.example.demoshopmarcin.categories;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoriesService {

    private CategoryRepository categoryRepository;

    @Autowired
    protected CategoriesService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
