package com.login.controller.advice;


import com.login.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginServiceControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<?> handleBadRequestException(final BadRequestException badex)
    {

        String value ="Error";
       // return new ResponseEntity<>(new ErrorResponse(value) , HttpStatus.BAD_REQUEST);
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex)
    {
        //return new ResponseEntity<>(UserResponse ,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
