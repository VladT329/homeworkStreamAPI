
package com.example.EmployeeList.controller;

import com.example.EmployeeList.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.EmployeeList.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary){
        return employeeService.add(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary){
        return employeeService.remove(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary){
        return employeeService.find(firstName, lastName, department, salary);
    }


    @GetMapping
    public Collection<Employee> findAll(){
        return employeeService.findAll();
    }
}
