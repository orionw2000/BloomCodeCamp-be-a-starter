package com.hcc.dao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.hcc.entities.Authority;
import com.hcc.exceptions.ResourceNotFoundException;

public class AuthorityDao {
    private final DynamoDBMapper mapper;

    public AuthorityDao(DynamoDBMapper mapper){
        this.mapper = mapper;
    }

    public Authority getAuthority(long id){
        Authority authority = mapper.load(Authority.class, id);
        if(authority == null){
            throw new ResourceNotFoundException("Authority for id " + id + " was not found.");
        }
        return authority;
    }

    public void saveAuthority(Authority authority){
        mapper.save(authority);
    }
}
