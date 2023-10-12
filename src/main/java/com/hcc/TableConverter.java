package com.hcc;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.hcc.dao.UserDao;
import com.hcc.endpoints.models.AssignmentTable;
import com.hcc.endpoints.models.UserTable;
import com.hcc.entities.Assignment;
import com.hcc.entities.User;

import java.time.LocalDate;

public class TableConverter {
    private static final UserDao dao = new UserDao(new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().build()));
            
    public static User convertTableToUser(UserTable table){
        User user = new User();
        user.setId(table.getId());
        user.setUsername(table.getUsername());
        user.setPassword(table.getPassword());
        user.setCohortStartDate(LocalDate.parse(table.getCohortStartDate()));
        return user;
    }
    public static Assignment convertTableToAssignment(AssignmentTable table){
        Assignment assignment = new Assignment();
        UserTable userTable = dao.getUserById(table.getUserId());
        assignment.setUser(convertTableToUser(userTable));
        assignment.setId(table.getId());
        assignment.setNumber(table.getNumber());
        assignment.setGithubUrl(table.getGithubUrl());
        assignment.setBranch(table.getBranch());
        assignment.setReviewVideoUrl(table.getReviewVideoUrl());
        assignment.setCodeReviewer(convertTableToUser(dao.getUserById(table.getCodeReviewerId())));
        return assignment;
    }
}
