package com.hcc.endpoints.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "be-a-starter-authorities")
public class AuthorityTable {
    private long id;
    private String authority;
    private long userId;

    @DynamoDBHashKey(attributeName = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "authority")
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @DynamoDBAttribute(attributeName = "username")
    public long getUserId() {
        return userId;
    }
    
}
