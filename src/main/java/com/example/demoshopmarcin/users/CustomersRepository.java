package com.example.demoshopmarcin.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer, Long> {
    boolean existsByUsername(String username);
}
