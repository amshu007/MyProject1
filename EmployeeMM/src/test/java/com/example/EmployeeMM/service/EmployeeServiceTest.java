package com.example.EmployeeMM.service;

import com.example.EmployeeMM.dao.Employee;
import com.example.EmployeeMM.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;



    @Disabled
    @Test
    public void getEmployeeByIdTest() {

        Employee byId = employeeRepository.findById(1).get();
        System.out.println(byId);
        assertNotNull(byId);
    }

    @Disabled
    @Test
     public void getEmployeeByIdTestMockObject() {


Employee emp = new Employee("Add", "City", "dept", 1, "Hero", 12000);
        Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.of(emp));

        Employee employee = employeeService.listEmployeeById(1);

        Assertions.assertEquals("Hero", employee.getName());
    }


    @Test
    public void addEmployeeShouldAddEmployeeSuccessfully() {

        Employee emp = new Employee("Add", "City", "dept", 1, "Hero", 12000);

        when(employeeRepository.save(emp)).thenReturn(emp);

        Employee addedEmployee = employeeService.addEmployee(emp);

        assertNotNull(addedEmployee);
        assertEquals(emp.getName(),addedEmployee.getName());
        assertEquals(emp.getId(),addedEmployee.getId());

    }



}

