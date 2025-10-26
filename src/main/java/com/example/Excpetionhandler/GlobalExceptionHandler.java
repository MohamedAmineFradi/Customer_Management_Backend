package com.example.Excpetionhandler;


import com.example.model.ErrorConfig;
import com.example.model.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private  ErrorConfig errorConfig ;


    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleIllegalStateException(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(errorConfig.getEr01Code());
        errorResponse.setMessage(errorConfig.getEr01msg());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR) ;
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(errorConfig.getEr02Code());
        errorResponse.setMessage(errorConfig.getEr02msg());

        return new ResponseEntity<>(errorResponse, HttpStatus.ACCEPTED) ;
    }



    @ExceptionHandler(StackOverflowError.class)
    public ResponseEntity<?> handleStackOverflowErro(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(errorConfig.getEr03Code());
        errorResponse.setMessage(errorConfig.getEr03msg());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR) ;
    }



}
