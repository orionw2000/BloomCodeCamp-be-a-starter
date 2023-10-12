package com.hcc.endpoints.requests;

import java.time.LocalDateTime;

public class ValidateTokenRequest {
    private LocalDateTime token;

    public ValidateTokenRequest() {
    }

    public ValidateTokenRequest(LocalDateTime token) {
        this.token = token;
    }
    public ValidateTokenRequest(Builder builder){
        this.token = builder.token;
    }

    public LocalDateTime getToken() {
        return token;
    }

    public void setToken(LocalDateTime token) {
        this.token = token;
    }
    
    public static final class Builder{
        private LocalDateTime token;
        
        private Builder(){}
        
        public Builder withToken(LocalDateTime tokenToUse){
            this.token = tokenToUse;
            return this;
        }
        
        public ValidateTokenRequest build(){return new ValidateTokenRequest(this);}
    }
}
