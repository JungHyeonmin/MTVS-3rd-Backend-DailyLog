package com.ohgiraffers.security.common;

public enum OhgiraffersRole {

    USER("USER"),
    ADMIN("ADMIN"),
    ALL("USER,ADMIN");

    private String role;

    OhgiraffersRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
