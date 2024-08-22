package com.dailycracker.employee.controller;

import com.dailycracker.employee.model.Employee;
import com.dailycracker.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
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
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        return employeeservice.getAllEmployees();
    }
}
