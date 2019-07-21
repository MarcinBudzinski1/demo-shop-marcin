package com.example.demoshopmarcin.products;

import com.example.demoshopmarcin.categories.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository<Product> productRepository;
    private ProductToProductToDtoBuilder productToProductToDtoBuilder;
    private CategoriesService categoriesService;

    @Autowired
    public ProductService(ProductRepository<Product> productRepository, ProductToProductToDtoBuilder productToProductToDtoBuilder, CategoriesService categoriesService) {
        this.productRepository = productRepository;
        this.productToProductToDtoBuilder = productToProductToDtoBuilder;
        this.categoriesService = categoriesService;
    }

    public void createNewProduct(String productName, Integer stockAmmont){
        // TODO: 16.07.2019  
    }
    public void updateProduct(ProductDto productDto){
        // TODO: 16.07.2019  
    }

    public Optional findProducts(Long id) {return productRepository.findById(id);}

}
