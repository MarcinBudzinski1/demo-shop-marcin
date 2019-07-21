package com.example.demoshopmarcin.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository<T extends Product> extends JpaRepository<Product, Long> {

    @Query("select count(c) from Category c")
    Long checkSize();

    Optional<T> findProductById(Long id);


}
