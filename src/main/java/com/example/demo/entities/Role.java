package com.example.demo.entities;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public enum  Role implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

    }

