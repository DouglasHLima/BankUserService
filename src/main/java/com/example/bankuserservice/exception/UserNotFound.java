package com.example.bankuserservice.exception;


public class UserNotFound extends RuntimeException{
    public UserNotFound() {
        super("User Not Found");
    }
}
