package com.hcc.endpoints.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "be-a-starter-assignments")
public class AssignmentTable {
    private long id;
    private long number;
    private String githubUrl;
    private String branch;
    private String reviewVideoUrl;
    private long userId;
    private long codeReviewerId;
    @DynamoDBRangeKey(attributeName = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @DynamoDBAttribute(attributeName = "number")
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
    @DynamoDBAttribute(attributeName = "github_url")
    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }
    @DynamoDBAttribute(attributeName = "branch")
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    @DynamoDBAttribute(attributeName = "code_review_video_url")
    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public void setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
    }
    @DynamoDBHashKey(attributeName = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long user) {
        this.userId = user;
    }
    @DynamoDBAttribute(attributeName = "code_reviewer_id")
    public long getCodeReviewerId() {
        return codeReviewerId;
    }

    public void setCodeReviewerId(long codeReviewer) {
        this.codeReviewerId = codeReviewer;
    }
}
