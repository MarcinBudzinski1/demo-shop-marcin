package com.example.demoshopmarcin.cart;

import com.example.demoshopmarcin.UserContextService;
import com.example.demoshopmarcin.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    private ProductRepository productRepository;
    private UserContextService userContextService;

    @Autowired
    public CartController(ProductRepository productRepository, UserContextService userContextService) {
        this.productRepository = productRepository;
        this.userContextService = userContextService;
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(){
        return null;
        // TODO: 19.07.2019
    }

    @PostMapping("/cartElements")
    public ResponseEntity<String> cartElements(){
        return null;
        // TODO: 19.07.2019  
    }
}
