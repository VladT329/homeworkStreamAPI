package com.example.EmployeeList.service;

import com.example.EmployeeList.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int department, int salary);

    Employee remove(String firstName, String lastName, int department, int salary);

    Employee find(String firstName, String lastName, int department, int salary);

    Collection<Employee> findAll();
}
