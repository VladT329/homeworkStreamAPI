package com.example.EmployeeList.service;

import com.example.EmployeeList.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceImpl {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMaxSalary(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> departmentId == employee.getDepartment())
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getMinSalary(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> departmentId == employee.getDepartment())
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getByDepartment(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> departmentId == employee.getDepartment())
                .toList();
    }

    public Map<Integer, List<Employee>> groupByDepartment(){
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
