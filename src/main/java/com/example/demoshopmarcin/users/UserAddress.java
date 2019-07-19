package com.example.demoshopmarcin.users;

import lombok.*;

import javax.persistence.Embeddable;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserAddress {

    public String street;
    public String building;
    public String flat;
    public String city;
    public String zipCode;
    public String country;
    public String phone;

}
