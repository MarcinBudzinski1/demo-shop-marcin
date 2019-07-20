package com.example.demoshopmarcin.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select count(c) from Category c")
    Long checkSize();


}
