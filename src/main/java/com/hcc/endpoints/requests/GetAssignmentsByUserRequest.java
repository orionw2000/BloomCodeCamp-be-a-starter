package com.hcc.endpoints.requests;

import java.util.Objects;

public class GetAssignmentsByUserRequest {
    private long id;

    public GetAssignmentsByUserRequest() {
    }

    public GetAssignmentsByUserRequest(Builder builder) {
        this.id = builder.id;
    }

    public GetAssignmentsByUserRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAssignmentsByUserRequest)) return false;
        GetAssignmentsByUserRequest that = (GetAssignmentsByUserRequest) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "GetAssignmentsByUserRequest{" +
                "id=" + id +
                '}';
    }
    public static GetAssignmentsByUserRequest.Builder builder() {return new GetAssignmentsByUserRequest.Builder();}

    public static final class Builder {
        private long id;

        public Builder() {

        }

        public GetAssignmentsByUserRequest.Builder withId(long idToUse) {
            this.id = idToUse;
            return this;
        }
        
        public GetAssignmentsByUserRequest build() { return new GetAssignmentsByUserRequest(this); }
    }
}
