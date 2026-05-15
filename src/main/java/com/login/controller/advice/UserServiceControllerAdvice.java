package com.login.controller.advice;

import com.login.exception.InvalidUserDetailsException;
import com.login.exception.UserNotFoundException;
import com.login.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class UserServiceControllerAdvice {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<?> handleBadRequestException(final BadRequestException badex)
    {

        String value ="Error";
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex)
    {

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidUserDetailsException.class)
    public ResponseEntity<?> handleInvalidUser(InvalidUserDetailsException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(
                ex.getMessage()), HttpStatus.BAD_REQUEST);

    }



}
