package com.example.EmployeeMM.controller;

import com.example.EmployeeMM.dao.Employee;
import com.example.EmployeeMM.exceptions.InvalidInvocation;
import com.example.EmployeeMM.exceptions.ResourceNotFoundException;
import com.example.EmployeeMM.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployees")
//    @PreAuthorize("hasAuthority('EMPLOYEE_READ')")
//    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Employee> getEmployees(){

        return employeeService.listEmployees();
    }


//    @GetMapping("/getEmployeeById")
//    public ResponseEntity<Employee> getEmployeeById(@RequestParam Integer id){
//
//        try{
//            Employee emp = employeeService.listEmployeeById(id)
//                    .orElseThrow(() -> new ResourceNotFoundException("User not found with ID :" + id));
//
//            return ResponseEntity.ok(emp);
//        }
//        catch(ResourceNotFoundException re){
//            System.out.println("An error occurred while retrieving the user" + re);
//            throw re;
//        }
//
//    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam Integer id){


            Employee emp = employeeService.listEmployeeById(id);
//                    .orElseThrow(() -> new RuntimeException("User not found with ID :" + id));
            return ResponseEntity.ok(emp);


        }



    @PostMapping("/addEmployee")
    @PreAuthorize("hasAuthority('EMPLOYEE_WRITE')")
    public Employee addEmployee(@RequestBody Employee emp){

        return employeeService.addEmployee(emp);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> empList){

        return employeeService.addEmployees(empList);
    }


}
