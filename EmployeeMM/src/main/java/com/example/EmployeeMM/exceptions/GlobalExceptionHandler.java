package com.example.EmployeeMM.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "An error occurred: " + ex);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> FoundException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "An error occurred: " + ex);
        body.put("messageSent", "hello user");

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);

//        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidInvocation.class)
    public ResponseEntity<Object> handleInvalidInvocationException(InvalidInvocation ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "An error occurred: " + ex);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
