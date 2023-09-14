package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private long id;
    private String authority;
    private User user;

    public Authority(String authority) {
        //TODO add id generator 
        this.authority = authority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
