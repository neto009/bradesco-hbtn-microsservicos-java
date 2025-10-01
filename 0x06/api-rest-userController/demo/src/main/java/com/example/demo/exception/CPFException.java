package com.example.demo.exception;

public class CPFException extends RuntimeException {
    
    public CPFException() {
        super();
    }
    
    public CPFException(String message) {
        super(message);
    }
    
    public CPFException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CPFException(Throwable cause) {
        super(cause);
    }
}