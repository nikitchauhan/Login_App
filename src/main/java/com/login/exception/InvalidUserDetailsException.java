package com.login.exception;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class InvalidUserDetailsException extends RuntimeException {

    private String field;



    public InvalidUserDetailsException(String message, String field) {
        super(message);
        this.field = field;
    }

}
