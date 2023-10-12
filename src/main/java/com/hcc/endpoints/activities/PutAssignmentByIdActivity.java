package com.hcc.endpoints.activities;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hcc.IdMaker;
import com.hcc.TableConverter;
import com.hcc.dao.AssignmentDao;
import com.hcc.endpoints.models.AssignmentTable;
import com.hcc.endpoints.requests.GetAssignmentByIdRequest;
import com.hcc.endpoints.requests.PutAssignmentByIdRequest;
import com.hcc.endpoints.results.GetAssignmentByIdResult;
import com.hcc.endpoints.results.PostAssignmentResult;
import com.hcc.endpoints.results.PutAssignmentByIdResult;
import com.hcc.entities.Assignment;
import com.hcc.enums.AssignmentStatusEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PutAssignmentByIdActivity implements RequestHandler<PutAssignmentByIdRequest, PutAssignmentByIdResult> {
    private final Logger log = LogManager.getLogger();
    private final AssignmentDao dao;

    public PutAssignmentByIdActivity(){
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        dao = new AssignmentDao(new DynamoDBMapper(client));
    }

    @Override
    public PutAssignmentByIdResult handleRequest(PutAssignmentByIdRequest request, Context context) {
        AssignmentTable assignmentTable = dao.getAssignmentById(request.getId());
        assignmentTable.setId(request.getId());
        if(request.getNumber() != 0){
            assignmentTable.setNumber(request.getNumber());
        }
        if(request.getGithubUrl() != null){
            assignmentTable.setGithubUrl(request.getGithubUrl());
        }
        if(request.getBranch() != null){
            assignmentTable.setBranch(request.getBranch());
        }
        if(request.getReviewVideoUrl() != null){
            assignmentTable.setReviewVideoUrl(request.getReviewVideoUrl());
        }
        if(request.getUserId() != 0){
            assignmentTable.setUserId(request.getUserId());
        }
        if(request.getReviewerId() != 0){
            assignmentTable.setCodeReviewerId(request.getReviewerId());
        }
        dao.saveAssignment(assignmentTable);
        Assignment assignment = TableConverter.convertTableToAssignment(assignmentTable);
        assignment.setStatus(AssignmentStatusEnum.ACTIVE.name());
        return new PutAssignmentByIdResult.Builder().withAssignment(assignment).build();
    }
}
