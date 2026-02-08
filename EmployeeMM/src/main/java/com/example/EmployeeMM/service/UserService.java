package com.example.EmployeeMM.service;

import com.example.EmployeeMM.dao.RegisterUserRequest;
import com.example.EmployeeMM.dao.UserResponse;
import com.example.EmployeeMM.dao.Users;
import com.example.EmployeeMM.repository.UserDetailsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   private final UserDetailsRepository userDetailsRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
        this.userDetailsRepository = userDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
//        TODO check if user is already present
        if(userDetailsRepository.findByUsername(registerUserRequest.getUsername()).isPresent()){
            throw new RuntimeException("User alreday present");
        }
//        TODO encode user password

        Users users =new Users();
        users.setUsername(registerUserRequest.getUsername());
        users.setRole(registerUserRequest.getRole());
        users.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));

//        TODO save user
        Users savedUser = userDetailsRepository.save(users);

        return new UserResponse(savedUser.getId(), savedUser.getRole().name(), savedUser.getUsername());


    }
}
