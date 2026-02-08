package com.example.EmployeeMM.dao;

import jakarta.persistence.*;

@Entity
@Table(name ="emoloyeeRecord")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String department;
    private String address;
    private int salary;

    public Employee() {
    }

    public Employee(String address, String city, String department, int id, String name, int salary) {
        this.address = address;
        this.city = city;
        this.department = department;
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{" +
                "address='" + address + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
