package com.example.demo.exception;

public class UserIdException extends RuntimeException {
    
    public UserIdException() {
        super();
    }
    
    public UserIdException(String message) {
        super(message);
    }
    
    public UserIdException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public UserIdException(Throwable cause) {
        super(cause);
    }
}
