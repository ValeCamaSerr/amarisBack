package com.example.amaris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amaris.models.Employee;
import com.example.amaris.services.EmployeeService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployee(id);
    }

    @CrossOrigin
    @GetMapping()
    public Employee[] getEmployees(){
        return employeeService.getEmployees();
    }
    
}
