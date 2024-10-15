package com.example.tdopeoject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        // Renvoie un message d'erreur simple sans la trace de la pile

        return new ResponseEntity<>("Error: " +ex.getMessage(),HttpStatus.NOT_FOUND);
    }

}