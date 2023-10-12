package com.hcc.endpoints.results;

import com.hcc.entities.Assignment;

import java.util.List;

public class GetAssignmentsByUserResult {
    List<Assignment> assignmentList;

    public GetAssignmentsByUserResult() {
    }
    public GetAssignmentsByUserResult(Builder builder){
        this.assignmentList = builder.assignmentList;
    }

    public GetAssignmentsByUserResult(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private List<Assignment> assignmentList;

        public Builder withAssignmentList(List<Assignment> assignmentListToUse) {
            this.assignmentList = assignmentListToUse;
            return this;
        }

        public GetAssignmentsByUserResult build() {
            return new GetAssignmentsByUserResult(this);
        }
    }
}
