package com.example.tdopeoject;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String post) {
        super(post);
    }
}
