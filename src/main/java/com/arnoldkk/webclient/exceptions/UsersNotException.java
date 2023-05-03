package com.arnoldkk.webclient.exceptions;


import org.springframework.http.HttpStatus;

public class UsersNotException extends RuntimeException{

    private HttpStatus httpStatus;

    public UsersNotException(String error){
        super(error);
    }

    public UsersNotException(String error, HttpStatus httpStatus){
        super(error);
        this.httpStatus = httpStatus;
    }

}
