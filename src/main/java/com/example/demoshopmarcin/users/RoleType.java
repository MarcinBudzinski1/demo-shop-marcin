package com.example.demoshopmarcin.users;

import lombok.Getter;

@Getter
public enum RoleType {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String roleName;

    RoleType(String roleName) {
        this.roleName = roleName;
    }
}
