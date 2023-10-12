package com.hcc.endpoints.activities;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hcc.TableConverter;
import com.hcc.dao.AssignmentDao;
import com.hcc.dao.UserDao;
import com.hcc.endpoints.models.AssignmentTable;
import com.hcc.endpoints.models.UserTable;
import com.hcc.endpoints.requests.GetAssignmentsByUserRequest;
import com.hcc.endpoints.requests.LoginRequest;
import com.hcc.endpoints.results.GetAssignmentsByUserResult;
import com.hcc.endpoints.results.LoginResult;
import com.hcc.entities.Assignment;
import com.hcc.exceptions.InvalidPasswordException;
import com.hcc.exceptions.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GetAssignmentsByUserActivity implements RequestHandler<GetAssignmentsByUserRequest, GetAssignmentsByUserResult> {
    private final Logger log = LogManager.getLogger();
    private final AssignmentDao dao;

    public GetAssignmentsByUserActivity(){
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        dao = new AssignmentDao(new DynamoDBMapper(client));
    }

    @Override
    public GetAssignmentsByUserResult handleRequest(GetAssignmentsByUserRequest request, Context context) {
        long requestId = request.getId();
        List<AssignmentTable> assignmentTables = dao.getAssignmentByUser(requestId);
        List<Assignment> convertedAssignments = new ArrayList<>();
        for(AssignmentTable table : assignmentTables){
            convertedAssignments.add(TableConverter.convertTableToAssignment(table));
        }
        return GetAssignmentsByUserResult.builder().withAssignmentList(convertedAssignments).build();
    }
}