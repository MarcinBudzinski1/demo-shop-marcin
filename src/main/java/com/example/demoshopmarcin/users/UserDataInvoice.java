package com.example.demoshopmarcin.users;

import lombok.*;

import javax.persistence.Embeddable;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserDataInvoice {

    public String CompanyName;
    public String NIP;
    public String country;
    public String street;
    public String building;
    public String premises;
    public String phone;
}
