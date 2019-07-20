package com.example.demoshopmarcin.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select count(c) from Category c")
    Long checkSize();
}
