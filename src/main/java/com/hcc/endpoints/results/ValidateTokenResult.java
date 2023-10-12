package com.hcc.endpoints.results;

public class ValidateTokenResult {
    private boolean valid;

    public ValidateTokenResult() {
    }

    public ValidateTokenResult(boolean valid) {
        this.valid = valid;
    }
    public ValidateTokenResult(Builder builder){
        this.valid = builder.valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    public static final class Builder{
        private boolean valid;
        
        public Builder(){}
        
        public Builder withValid(boolean validToUse){
            this.valid = validToUse;
            return this;
        }
        public ValidateTokenResult build(){return new ValidateTokenResult(this);}
    }
}
