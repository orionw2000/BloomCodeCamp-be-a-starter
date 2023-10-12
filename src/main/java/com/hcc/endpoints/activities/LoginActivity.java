package com.hcc.endpoints.activities;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hcc.TableConverter;
import com.hcc.dao.UserDao;
import com.hcc.endpoints.requests.LoginRequest;
import com.hcc.endpoints.results.LoginResult;
import com.hcc.endpoints.models.UserTable;
import com.hcc.entities.User;
import com.hcc.exceptions.InvalidPasswordException;
import com.hcc.exceptions.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginActivity implements RequestHandler<LoginRequest, LoginResult> {
    private final Logger log = LogManager.getLogger();
    private final UserDao dao;
    
    public LoginActivity(){
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        dao = new UserDao(new DynamoDBMapper(client));
    }
    
    @Override
    public LoginResult handleRequest(LoginRequest request, Context context) {
        String requestUsername = request.getUsername();
        String requestPassword = request.getPassword();
        if(     requestUsername == "" || 
                requestUsername == null || 
                requestPassword == "" || 
                requestPassword == null){
            throw new ResourceNotFoundException("Please fill in your username and password");
        }
        UserTable user = dao.getUser(requestUsername);
        User userModel = TableConverter.convertTableToUser(user);
        if(!user.getPassword().equals(requestPassword)){
            throw new InvalidPasswordException("Invalid password");
        }
        return LoginResult.builder().withUser(userModel).build();
    }
}
