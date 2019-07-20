package com.example.demoshopmarcin.users;


import com.example.demoshopmarcin.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
public class User extends BaseEntity {

    private String username;
    @Column(unique = true)
    private String eMail;
    private String passwordHash;

    @ManyToMany
    @Cascade(value = CascadeType.ALL)
    @JoinTable(name = "user_role")
    private Set<Role> roles;
    private Status status;
    private UserAddress userAddress;


}
