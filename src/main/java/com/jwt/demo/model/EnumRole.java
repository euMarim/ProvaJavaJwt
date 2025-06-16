package com.jwt.demo.model;

public enum EnumRole {
    ADMIN("ADMIN"),
    USER("USER");


    private final String role;

    EnumRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
