package com.hcc.dao;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.hcc.endpoints.models.AssignmentTable;
import com.hcc.entities.Assignment;
import com.hcc.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignmentDao {
    private final DynamoDBMapper mapper;

    public AssignmentDao(DynamoDBMapper mapper){
        this.mapper = mapper;
    }

    public List<AssignmentTable> getAssignmentByUser(long userId){
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":user_id", new AttributeValue().withN(String.valueOf(userId)));
        ScanRequest scanRequest = new ScanRequest()
                .withTableName("be-a-starter-assignments")
                .withFilterExpression("userId = :user_id")
                .withExpressionAttributeValues(expressionAttributeValues);
        ScanResult result = AmazonDynamoDBClientBuilder.defaultClient().scan(scanRequest);
        if(result.getItems().isEmpty()){
            throw new ResourceNotFoundException("Assignments for user ID " + userId +" were not found.");
        }
        List<Map<String, AttributeValue>> assignments = new ArrayList<>(result.getItems());
        List<AssignmentTable> listOfAssignmentsPerUser = new ArrayList<>();
        for(Map<String, AttributeValue> assignment : assignments){
            AssignmentTable assignmentTable = new AssignmentTable();
            assignmentTable.setId(Long.parseLong(assignment.get("id").getN()));
            assignmentTable.setNumber(Long.parseLong(assignment.get("number").getN()));
            assignmentTable.setGithubUrl(assignment.get("github_url").getS());
            assignmentTable.setBranch(assignment.get("branch").getS());
            assignmentTable.setReviewVideoUrl(assignment.get("code_review_video_url").getS());
            assignmentTable.setUserId(Long.parseLong(assignment.get("user_id").getN()));
            assignmentTable.setCodeReviewerId(Long.parseLong(assignment.get("code_reviewer_id").getN()));
            listOfAssignmentsPerUser.add(assignmentTable);
        }
        return listOfAssignmentsPerUser;
    }
    
    public AssignmentTable getAssignmentById(long id){
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":id", new AttributeValue().withN(String.valueOf(id)));
        ScanRequest scanRequest = new ScanRequest()
                .withTableName("be-a-starter-assignments")
                .withFilterExpression("id = :id")
                .withExpressionAttributeValues(expressionAttributeValues);
        ScanResult result = AmazonDynamoDBClientBuilder.defaultClient().scan(scanRequest);
        //Should only be 1 assignment.
        Map<String, AttributeValue> assignment = new HashMap<>(result.getItems().get(1));
        AssignmentTable assignmentTable = new AssignmentTable();
        assignmentTable.setId(Long.parseLong(assignment.get("id").getN()));
        assignmentTable.setNumber(Long.parseLong(assignment.get("number").getN()));
        assignmentTable.setGithubUrl(assignment.get("github_url").getS());
        assignmentTable.setBranch(assignment.get("branch").getS());
        assignmentTable.setReviewVideoUrl(assignment.get("code_review_video_url").getS());
        assignmentTable.setUserId(Long.parseLong(assignment.get("user_id").getN()));
        assignmentTable.setCodeReviewerId(Long.parseLong(assignment.get("code_reviewer_id").getN()));
        return assignmentTable;
    }

    public void saveAssignment(AssignmentTable assignment){
        mapper.save(assignment);
    }
}
