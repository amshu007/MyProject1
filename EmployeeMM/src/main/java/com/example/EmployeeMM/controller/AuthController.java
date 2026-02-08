package com.example.EmployeeMM.controller;

import com.example.EmployeeMM.dao.AuthRequest;
import com.example.EmployeeMM.dao.Users;
import com.example.EmployeeMM.repository.UserDetailsRepository;
import com.example.EmployeeMM.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest){
    try {

//      TODO  User will be authenticated first here before generating JWT token
         authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
           );


//         TODO create JWT Token: JWT token will be generated here after user authentication is successful

       return  jwtUtil.generateToken(authRequest.getUsername());

//        return "jwt token";
         }
        catch (Exception e){
            throw e;
         }


    }






}
