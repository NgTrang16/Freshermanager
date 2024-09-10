package com.example.FresherManager.exceptions;

public class FresherManagerException extends RuntimeException {
    private String message;
    public FresherManagerException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
