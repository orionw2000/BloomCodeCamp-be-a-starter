package com.hcc.endpoints.activities;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hcc.TableConverter;
import com.hcc.dao.AssignmentDao;
import com.hcc.endpoints.models.AssignmentTable;
import com.hcc.endpoints.requests.GetAssignmentByIdRequest;
import com.hcc.endpoints.requests.GetAssignmentsByUserRequest;
import com.hcc.endpoints.results.GetAssignmentByIdResult;
import com.hcc.endpoints.results.GetAssignmentsByUserResult;
import com.hcc.entities.Assignment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GetAssignmentByIdActivity implements RequestHandler<GetAssignmentByIdRequest, GetAssignmentByIdResult> {
    private final Logger log = LogManager.getLogger();
    private final AssignmentDao dao;

    public GetAssignmentByIdActivity(){
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        dao = new AssignmentDao(new DynamoDBMapper(client));
    }

    @Override
    public GetAssignmentByIdResult handleRequest(GetAssignmentByIdRequest request, Context context) {
        long requestId = request.getId();
        AssignmentTable assignmentTable = dao.getAssignmentById(requestId);
        Assignment convertedAssignment = TableConverter.convertTableToAssignment(assignmentTable);
        
        return GetAssignmentByIdResult.builder().withAssignment(convertedAssignment).build();
    }
}