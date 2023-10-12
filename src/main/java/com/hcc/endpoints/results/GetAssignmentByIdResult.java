package com.hcc.endpoints.results;

import com.hcc.entities.Assignment;

import java.util.List;

public class GetAssignmentByIdResult {
    private Assignment assignment;

    public GetAssignmentByIdResult() {
    }
    
    public GetAssignmentByIdResult(Builder builder){
        this.assignment = builder.assignment;
    }

    public GetAssignmentByIdResult(Assignment assignment) {
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public static Builder builder() {return new GetAssignmentByIdResult.Builder();}

    public static final class Builder {
        private Assignment assignment;

        public Builder withAssignment(Assignment assignmentToUse) {
            this.assignment = assignmentToUse;
            return this;
        }

        public GetAssignmentByIdResult build() {
            return new GetAssignmentByIdResult(this);
        }
    }
}
