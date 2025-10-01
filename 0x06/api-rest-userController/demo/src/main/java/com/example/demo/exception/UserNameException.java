package com.example.demo.exception;

public class UserNameException extends RuntimeException {
    
    public UserNameException() {
        super();
    }
    
    public UserNameException(String message) {
        super(message);
    }
    
    public UserNameException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public UserNameException(Throwable cause) {
        super(cause);
    }
}
