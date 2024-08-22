package com.dailycracker.employee.controller;

import com.dailycracker.employee.model.Employee;
import com.dailycracker.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService employeeservice;
    public EmployeeController(EmployeeService employeeservice) {
        this.employeeservice = employeeservice;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employeeservice.createEmployee(employee);
        return employee;
    }
}
