package com.example.user.service.exceptions;

import com.example.user.service.payload.ErrorResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseApi> handlerResResourceNotFoundException(ResourceNotFoundException ex){

        String message = ex.getMessage();
//        ErrorResponseApi response = ErrorResponseApi.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

        ErrorResponseApi response = new ErrorResponseApi();
        response.setMessage(message);
        response.setSuccess(true);
        response.setStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);





    }
}
