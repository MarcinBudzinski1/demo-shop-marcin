package com.example.demoshopmarcin.users;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegistrationService {

    private PasswordEncoder passwordEncoder;
    private UserRepository<Customer> userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserRegistrationService(PasswordEncoder passwordEncoder, UserRepository<Customer> userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void registerUser(UserRegistrationDTO userRegistrationDTO ){
        Customer user =UserRegistrationDTOBuilder.createCustomer(userRegistrationDTO, passwordEncoder);
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserExistsException("User with username " + user.getUsername() + "already exists in database");
        } else {
            addUser(user);
        }
    }

    public void addUser(Customer user){
        Role role = Optional.ofNullable(roleRepository.findByRoleName("ROLE_USER"))
                .orElseGet(()->roleRepository.save(new Role(RoleType.USER.getRoleName())));
        user.setRoles(Sets.newHashSet(role));
        userRepository.save(user);
    }
}
