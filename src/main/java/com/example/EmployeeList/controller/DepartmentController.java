package com.example.EmployeeList.controller;

import com.example.EmployeeList.model.Employee;
import com.example.EmployeeList.service.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl service;

    public DepartmentController(DepartmentServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee max(@RequestParam int departmentId) {
        return service.getMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee min(@RequestParam int departmentId) {
        return service.getMinSalary(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> all(@RequestParam int departmentId) {
        return service.getByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all(){
        return service.groupByDepartment();
    }
}
