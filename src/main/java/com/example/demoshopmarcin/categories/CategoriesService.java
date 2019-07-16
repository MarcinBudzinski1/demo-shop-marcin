package com.example.demoshopmarcin.categories;

public abstract class CategoriesService {

    private CategoryRepository categoryRepository;

    protected CategoriesService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
