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
import com.hcc.endpoints.requests.ValidateTokenRequest;
import com.hcc.endpoints.results.GetAssignmentByIdResult;
import com.hcc.endpoints.results.ValidateTokenResult;
import com.hcc.entities.Assignment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ValidateTokenActivity implements RequestHandler<ValidateTokenRequest, ValidateTokenResult> {
    private final Logger log = LogManager.getLogger();
    

    public ValidateTokenActivity(){
        
    }

    @Override
    public ValidateTokenResult handleRequest(ValidateTokenRequest request, Context context) {
        long hours = ChronoUnit.HOURS.between(request.getToken(), LocalDateTime.now());
        long minutes = ChronoUnit.MINUTES.between(request.getToken(), LocalDateTime.now());
        boolean isValid = true;
        //1 hour 30 min
        if(hours > 1 || (minutes > 29 && hours ==1)){
            isValid = false;
        }
        
        return new ValidateTokenResult.Builder().withValid(isValid).build();
    }
}
