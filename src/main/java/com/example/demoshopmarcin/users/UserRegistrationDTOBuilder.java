package com.example.demoshopmarcin.users;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRegistrationDTOBuilder {

    public static Customer createCustomer(UserRegistrationDTO userRegistrationDTO, PasswordEncoder passwordEncoder){
        Customer customer = new Customer();
        customer.setUsername(userRegistrationDTO.getUsername().trim());
        customer.setEMail(userRegistrationDTO.getEMail().trim());
        customer.setPasswordHash(passwordEncoder.encode(userRegistrationDTO.getPasswordHash().trim()));

        return customer;
    }

}
