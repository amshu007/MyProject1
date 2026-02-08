//package com.example.EmployeeMM.service;
//
//import com.example.EmployeeMM.dao.Role;
//import com.example.EmployeeMM.dao.String;
//import com.example.EmployeeMM.dao.Users;
//import com.example.EmployeeMM.repository.UserDetailsRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AdminUserInitializer {
//
//    @Bean
//    public CommandLineRunner createAdminUser(UserDetailsRepository userDetailsRepository,
//                                             PasswordEncoder passwordEncoder){
//
////        return args -> {
////            if(userDetailsRepository.findByUsername("admin").isEmpty()){
////                    Users admin = new Users();
////                    admin.setUsername("admin");
////                    admin.setPassword(passwordEncoder.encode("admin12345")); // securely stores password
////                admin.setRole(Role.ADMIN);
////
////                userDetailsRepository.save(admin);
////                System.out.println("Default admin user created successfully.");
////
////
////            }
////
////            if(userDetailsRepository.findByUsername("user").isEmpty()){
////                Users user = new Users();
////                user.setUsername("user");
////                user.setPassword(passwordEncoder.encode("user12345")); // securely stores password
////                user.setRole(String.USER);
////
////                userDetailsRepository.save(user);
////                System.out.println("Default user created successfully.");
//
//
//            }
//        };
//    }
//
//
//}
