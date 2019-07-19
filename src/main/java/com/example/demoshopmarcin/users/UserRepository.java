package com.example.demoshopmarcin.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    Customer findByUsername(String username);
}
