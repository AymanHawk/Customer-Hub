package com.sample.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice // used to show this will be used for exception handling
public class ApiExceptionHandler {


    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        //create payload containing the exception details

        HttpStatus badRequest = HttpStatus.BAD_REQUEST; // alt+cmd+v to set varible equal to highlighted entity

        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        //return the response entity
        return new ResponseEntity<>(apiException, badRequest);
    }

}
