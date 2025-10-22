package com.example.user.service.payload;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseApi {

    private String message;
    private Boolean success;
    private HttpStatus status;

}
