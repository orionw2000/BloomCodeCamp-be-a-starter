package com.hcc.repositories;

import com.hcc.entities.User;

import java.util.Optional;

public class UserRepository {
    public UserRepository() {
    }
    
    public Optional<User> findByUsername(String username){
        return Optional.empty();
    }
}
