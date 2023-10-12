package com.hcc.endpoints.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.hcc.entities.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@DynamoDBTable(tableName = "be-a-starter-users")
public class UserTable {
    private long id;
    private String cohortStartDate;
    private String username;
    private String password;
    
    @DynamoDBRangeKey(attributeName = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "cohort_start_date")
    public String getCohortStartDate() {
        return cohortStartDate;
    }

    public void setCohortStartDate(String cohortStartDate) {
        this.cohortStartDate = cohortStartDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @DynamoDBHashKey(attributeName = "username")
    public String getUsername() {
        return username;
    }
    
    @DynamoDBAttribute(attributeName = "password")
    public String getPassword() {
        return password;
    }
}
