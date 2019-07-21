package com.example.demoshopmarcin.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> {

    Optional<T> findByUsername(String username);
}
