package com.example.demoshopmarcin.MockData;

import com.example.demoshopmarcin.categories.CategoryRepository;
import com.example.demoshopmarcin.products.CompanyRepository;
import com.example.demoshopmarcin.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MockProducts {

    private CategoryRepository categoryRepository;
    private CompanyRepository companyRepository;
    private ProductRepository productRepository;
    
    @Autowired
    public MockProducts(CategoryRepository categoryRepository, CompanyRepository companyRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.companyRepository = companyRepository;
        this.productRepository = productRepository;
    }
    
    @PostConstruct
    public void createDataForProducts(){
        if (categoryRepository.checkSize() == 0){
            createExampleCategories();
        }
        
        if (companyRepository.checkSize() == 0){
            createExampleCompanies();
        }
        
        if (productRepository.checkSize() == 0){
            createExampleProducts();
        }
    }

    private void createExampleProducts() {
        // TODO: 20.07.2019  
    }

    private void createExampleCompanies() {
        // TODO: 20.07.2019  
    }

    private void createExampleCategories() {
        // TODO: 20.07.2019  
    }
}
