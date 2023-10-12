package com.hcc.entities;

import com.hcc.endpoints.models.UserTable;
import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private long id;
    private String authority;
    private UserTable user;

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

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }
}
