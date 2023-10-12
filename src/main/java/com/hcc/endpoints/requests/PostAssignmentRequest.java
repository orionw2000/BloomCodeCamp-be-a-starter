package com.hcc.endpoints.requests;

public class PostAssignmentRequest {
    private String reviewVideoUrl;
    private long userId;
    private String branch;
    private String githubUrl;
    private long number;
    private long reviewerId;

    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public void setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public PostAssignmentRequest() {
    }

    public PostAssignmentRequest(long id) {
        this.userId = id;
    }

    public PostAssignmentRequest(Builder builder) {
        this.userId = builder.id;
        this.branch = builder.branch;
        this.githubUrl = builder.githubUrl;
        this.number = builder.number;
        this.reviewerId = builder.reviewerId;
        this.reviewVideoUrl = builder.reviewVideoUrl;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private long id;
        private String branch;
        private String githubUrl;
        private long number;
        private long reviewerId;
        private String reviewVideoUrl;

        public Builder() {

        }

        public Builder withUserId(long userIdToUse) {
            this.id = userIdToUse;
            return this;
        }
        public Builder withBranch(String branchToUse) {
            this.branch = branchToUse;
            return this;
        }
        public Builder withGithubUrl(String urlToUse) {
            this.githubUrl = urlToUse;
            return this;
        }
        public Builder withNumber(long numberToUse) {
            this.number = numberToUse;
            return this;
        }
        public Builder withReviewerId(long idToUse) {
            this.reviewerId = idToUse;
            return this;
        }
        public Builder withReviewVideoUrl(String urlToUse) {
            this.reviewVideoUrl = urlToUse;
            return this;
        }
        

        public PostAssignmentRequest build() { return new PostAssignmentRequest(this); }
    }
}
