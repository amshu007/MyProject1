package com.example.EmployeeMM.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInvocation extends RuntimeException{


    public InvalidInvocation(String message) {
        super(message);
    }
}
