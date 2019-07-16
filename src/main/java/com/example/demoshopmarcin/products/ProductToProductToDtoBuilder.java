package com.example.demoshopmarcin.products;

import com.example.demoshopmarcin.BaseEntity;
import com.example.demoshopmarcin.categories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductToProductToDtoBuilder {

    private CategoryRepository categoryRepository;
    private CompanyRepository companyRepository;
    private ProductRepository productRepository;

    @Autowired
    public ProductToProductToDtoBuilder(CategoryRepository categoryRepository, CompanyRepository companyRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.companyRepository = companyRepository;
        this.productRepository = productRepository;
    }

    public ProductDto buildProduct(Product product){
        return ProductDto.builder()
                .categoryId(Optional.ofNullable(product.getCategory()).map(BaseEntity::getId).orElse(null))
                .companyName(Optional.ofNullable(product.getCompanyName()).map(Company::getCompanyName).orElse(null))
                .ProductName(product.getProductName())
                .price(product.getPrice())
                .url(product.getUrl())
                .description(product.getDescription())
                .build();
    }
}
