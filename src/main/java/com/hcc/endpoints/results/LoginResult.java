package com.hcc.endpoints.results;

import com.hcc.entities.User;

public class LoginResult {
    User user;

    public LoginResult() {
    }

    public LoginResult(User user) {
        this.user = user;
    }

    public LoginResult(Builder builder) {
        this.user = builder.user;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Builder builder() {return new Builder();}
    public static final class Builder {
        private User user;

        public Builder withUser(User user) {
            this.user = user;
            return this;
        }

        public LoginResult build() {return new LoginResult(this);}
    }
}
