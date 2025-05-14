package com.example.job_queue_system.common.exception;

public class CustomBadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomBadRequestException(String message) {
        super(message);
    }

   
    
}
