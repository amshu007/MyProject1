package com.example.EmployeeMM.service;

import com.example.EmployeeMM.dao.Employee;
import com.example.EmployeeMM.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> listEmployees(){

        return employeeRepository.findAll();

    }

    public Employee listEmployeeById(Integer id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not found"));
    }

    public Employee addEmployee(Employee emp){

        return employeeRepository.save(emp);

    }

    public List<Employee> addEmployees(List<Employee> empList){

       return employeeRepository.saveAll(empList);

    }



}
