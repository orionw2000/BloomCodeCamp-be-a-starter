package com.hcc.endpoints.results;

import com.hcc.entities.Assignment;

public class PostAssignmentResult {
    private Assignment assignment;

    public PostAssignmentResult() {
    }

    public PostAssignmentResult(Builder builder){
        this.assignment = builder.assignment;
    }

    public PostAssignmentResult(Assignment assignment) {
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

        public PostAssignmentResult build() {
            return new PostAssignmentResult(this);
        }
    }
}
