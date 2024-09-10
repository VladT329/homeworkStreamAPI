package com.example.EmployeeList.service;

import com.example.EmployeeList.exceptions.EmployeeAlreadyAddedException;
import com.example.EmployeeList.exceptions.EmployeeNotFoundException;
import com.example.EmployeeList.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int departament, int salary) {
        Employee employee = new Employee(firstName, lastName, departament, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int departament, int salary) {
        Employee employee = new Employee(firstName, lastName, departament, salary);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int departament, int salary) {
        Employee employee = new Employee(firstName, lastName, departament, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
