package com.example.demoshopmarcin.products;

import com.example.demoshopmarcin.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Company extends BaseEntity {
    private String CompanyName;
    private String country;

}
