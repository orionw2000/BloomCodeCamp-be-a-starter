package com.hcc.endpoints.requests;

public class GetAssignmentByIdRequest {
    private long id;
    public GetAssignmentByIdRequest() {
    }

    public GetAssignmentByIdRequest(long id) {
        this.id = id;
    }
    
    public GetAssignmentByIdRequest(Builder builder) {
        this.id = builder.id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private long id;

        public Builder() {

        }

        public GetAssignmentByIdRequest.Builder withId(long idToUse) {
            this.id = idToUse;
            return this;
        }

        public GetAssignmentByIdRequest build() { return new GetAssignmentByIdRequest(this); }
    }
}
