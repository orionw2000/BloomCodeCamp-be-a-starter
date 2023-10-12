package com.hcc;

import java.util.Random;

public class IdMaker {
    private static final Random random = new Random();
    
    public static int generateStudentId(){
        return random.nextInt(900000) + 100000;
    }
    public static int generateAuthorityId(){
        return random.nextInt(900000) + 200000;
    }
    public static int generateAssignmentId(){return random.nextInt(900000) + 300000;}
}
