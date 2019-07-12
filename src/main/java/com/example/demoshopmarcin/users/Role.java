package com.example.demoshopmarcin.users;

import com.example.demoshopmarcin.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {

    private String role;
}
