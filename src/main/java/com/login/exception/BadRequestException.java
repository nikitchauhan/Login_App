package com.login.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException {

    private final String errorCode;
    private final String fieldName;
    private final String fieldValue;

    public BadRequestException(String msg,String errorCode,String fieldName,String fieldValue)
    {
        super(msg);
        this.errorCode=errorCode;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;

    }
}
