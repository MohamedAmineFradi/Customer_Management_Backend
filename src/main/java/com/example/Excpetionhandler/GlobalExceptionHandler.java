package com.example.handler;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleException(IllegalStateException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleException(){
        return ResponseEntity
                .notFound()
                .build();
    }



    @ExceptionHandler(StackOverflowError.class)
    public ResponseEntity<?> handleException(StackOverflowError error){
        return ResponseEntity.badRequest().body("il y a un boucle infinie ");
    }


    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> exception(RuntimeException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }


}
