package com.login.handler;

import com.login.controller.advice.LoginServiceControllerAdvice;
import com.login.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;

@Component
public class CircuitBreakerFallbackHandler {


    @Autowired
    LoginServiceControllerAdvice loginServiceControllerAdvice;

    public void checkException(Throwable throwable) throws Throwable {
        if (throwable instanceof MissingServletRequestParameterException)
            throw ((MissingServletRequestParameterException) throwable);

    }

    private ResponseEntity<?> handleFallback(Throwable throwable) {

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private ResponseEntity<?> ignoreException(Throwable throwable) {
        if (throwable instanceof UserNotFoundException) {

            return loginServiceControllerAdvice.handleUserNotFoundException((UserNotFoundException) throwable);
        }
        else{
            return null;
        }
    }
}



