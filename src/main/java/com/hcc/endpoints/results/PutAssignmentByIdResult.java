package com.hcc.endpoints.results;

import com.hcc.entities.Assignment;

public class PutAssignmentByIdResult {
    private Assignment assignment;

    public PutAssignmentByIdResult() {
    }

    public PutAssignmentByIdResult(Builder builder){
        this.assignment = builder.assignment;
    }

    public PutAssignmentByIdResult(Assignment assignment) {
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private Assignment assignment;

        public Builder withAssignment(Assignment assignmentToUse) {
            this.assignment = assignmentToUse;
            return this;
        }

        public PutAssignmentByIdResult build() {
            return new PutAssignmentByIdResult(this);
        }
    }
}
