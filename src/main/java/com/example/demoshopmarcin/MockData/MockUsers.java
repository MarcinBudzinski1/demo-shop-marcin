package com.example.demoshopmarcin.MockData;

import com.example.demoshopmarcin.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Random;

@Component
public class MockUsers {

    private UserRepository<Customer> userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    private Random randomGenerator = new Random();

    @Autowired
    public MockUsers(UserRepository<Customer> userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void mockUsers(){
        if (!(roleRepository.count() == 0)){
            createRoles();
        }

        if (!(userRepository.count() == 0)){
            createUsers();
        }
    }

    private void createUsers() {
        // TODO: 20.07.2019


        Customer customer = new Customer();
        userRepository.save(customer);
        customer.setUsername("user12345");
        customer.setEMail("user@user12345.pl");
        customer.setPasswordHash(passwordEncoder.encode("user12345"));
        customer.setStatus(Status.ACTIVE);
        customer.setUserAddress(UserAddress.builder()
                .street(createRandomStreet())
                .building(createRandomBuilding())
                .flat(createRandomFlat())
                .city(createRandomCity())
                .zipCode(createRandomZipCode())
                .country("Polska")
                .phone(createRandomPhone())
                .build());
        userRepository.save(customer);

    }

    private String createRandomPhone() {
        int[] phone = new int[8];
        for (int i=0;i<phone.length;i++){phone[i] = randomGenerator.nextInt(9);}
        return Arrays.toString(phone);
    }

    private String createRandomCity() {

        // TODO: 20.07.2019
        return "Warszawa";
    }

    private String createRandomZipCode() {
        int[] first = new int[1];
        int[] second = new int[2];
        for (int i=0;i<first.length;i++){first[i] = randomGenerator.nextInt(9);}
        for (int i=0;i<second.length;i++){second[i] = randomGenerator.nextInt(9);}
        return Arrays.toString(first) + "-" + Arrays.toString(second);
    }

    private String createRandomFlat() {
        randomGenerator.nextInt(50);
        return randomGenerator.toString();
    }

    private String createRandomBuilding() {
        randomGenerator.nextInt(50);
        return randomGenerator.toString();
    }

    private String createRandomStreet() {
        // TODO: 20.07.2019
        return "Długa";
    }

    private void createRoles() {
        // TODO: 20.07.2019
            if (roleRepository.count() == 0) {
                Role role = new Role();
                role.setRoleName("User");
                roleRepository.save(role);
                Role role1 = new Role("Admin");
                role.setRoleName("Admin");
                roleRepository.save(role1);
            }

    }

}
