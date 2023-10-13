package com.hcc.dao;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.hcc.endpoints.models.UserTable;
import com.hcc.entities.User;
import com.hcc.exceptions.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private final DynamoDBMapper mapper;
    
    public UserDao(DynamoDBMapper mapper){
        this.mapper = mapper;
    }
    
    public UserTable getUser(String username){
        UserTable user = mapper.load(UserTable.class, username);
        if(user == null){
            throw new ResourceNotFoundException("User for username " + username + " was not found.");
        }
        return user;
    }
    
    public UserTable getUserById(long id){
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":id", new AttributeValue().withN(String.valueOf(id)));
        ScanRequest scanRequest = new ScanRequest()
                .withTableName("be-a-starter-users")
                .withFilterExpression("id = :id")
                .withExpressionAttributeValues(expressionAttributeValues);
        ScanResult result = AmazonDynamoDBClientBuilder.defaultClient().scan(scanRequest);
        if(result.getItems().isEmpty()){
            throw new ResourceNotFoundException("User for id " + id + " was not found.");
        }
        //Should only be 1 user.
        Map<String, AttributeValue> userMap = new HashMap<>(result.getItems().get(1));
        UserTable user = new UserTable();
        user.setPassword(userMap.get("password").getS());
        user.setUsername(userMap.get("username").getS());
        user.setId(Long.parseLong(userMap.get("id").getN()));
        user.setCohortStartDate(userMap.get("cohort_start_date").getS());
        
        return user;
    }
    
    public void saveUser(UserTable user){
        mapper.save(user);
    }
}
