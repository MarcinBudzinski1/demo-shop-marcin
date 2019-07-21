package com.example.demoshopmarcin.cart;

import com.example.demoshopmarcin.UserContextService;
import com.example.demoshopmarcin.products.Product;
import com.example.demoshopmarcin.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    private ProductRepository<Product> productRepository;
    private UserContextService userContextService;

    @Autowired
    public CartController(ProductRepository<Product> productRepository, UserContextService userContextService) {
        this.productRepository = productRepository;
        this.userContextService = userContextService;
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestParam(required = false) String prodId){
        productRepository.findProductById(Long.valueOf(prodId)).ifPresent(userContextService::addProductToCart);
        return ResponseEntity.ok().body(userContextService.getCartAsJson());
        // TODO: 19.07.2019
    }

    @PostMapping("/cartElements")
    public ResponseEntity<String> cartElements(){
        return null;
        // TODO: 19.07.2019  
    }
}
