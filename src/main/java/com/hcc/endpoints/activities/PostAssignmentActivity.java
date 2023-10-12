package com.hcc.endpoints.activities;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hcc.IdMaker;
import com.hcc.TableConverter;
import com.hcc.dao.AssignmentDao;
import com.hcc.dao.UserDao;
import com.hcc.endpoints.models.AssignmentTable;
import com.hcc.endpoints.models.UserTable;
import com.hcc.endpoints.requests.LoginRequest;
import com.hcc.endpoints.requests.PostAssignmentRequest;
import com.hcc.endpoints.results.LoginResult;
import com.hcc.endpoints.results.PostAssignmentResult;
import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.enums.AssignmentStatusEnum;
import com.hcc.exceptions.InvalidPasswordException;
import com.hcc.exceptions.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostAssignmentActivity implements RequestHandler<PostAssignmentRequest, PostAssignmentResult> {
    private final Logger log = LogManager.getLogger();
    private final AssignmentDao assignmentDao;
    
    public PostAssignmentActivity(){
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        assignmentDao = new AssignmentDao(new DynamoDBMapper(client));
    }

    @Override
    public PostAssignmentResult handleRequest(PostAssignmentRequest request, Context context) {
        AssignmentTable assignmentTable = new AssignmentTable();
        assignmentTable.setId(IdMaker.generateAssignmentId());
        assignmentTable.setNumber(request.getNumber());
        assignmentTable.setGithubUrl(request.getGithubUrl());
        assignmentTable.setBranch(request.getBranch());
        assignmentTable.setReviewVideoUrl(request.getReviewVideoUrl());
        assignmentTable.setUserId(request.getUserId());
        assignmentTable.setCodeReviewerId(request.getReviewerId());
        assignmentDao.saveAssignment(assignmentTable);
        Assignment assignment = TableConverter.convertTableToAssignment(assignmentTable);
        assignment.setStatus(AssignmentStatusEnum.ACTIVE.name());
        return new PostAssignmentResult.Builder().withAssignment(assignment).build();
    }
}
