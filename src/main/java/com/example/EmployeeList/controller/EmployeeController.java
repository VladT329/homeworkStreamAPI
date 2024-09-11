
package com.example.EmployeeList.controller;

import com.example.EmployeeList.exceptions.ValidationException;
import com.example.EmployeeList.model.Employee;
import org.apache.commons.lang3.StringUtils;
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
        validate(firstName, lastName);
        return employeeService.add(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary){
        validate(firstName, lastName);
        return employeeService.remove(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary){
        validate(firstName, lastName);
        return employeeService.find(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), department, salary);
    }


    @GetMapping
    public Collection<Employee> findAll(){
        return employeeService.findAll();
    }

    private void validate (String... values){
            for (String value : values){
                if(!StringUtils.isAlpha(value)){
                    throw new ValidationException();
                }
        }
    }
}
