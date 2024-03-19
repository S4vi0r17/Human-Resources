package com.nacho.hr.controller;

import com.nacho.hr.model.Employee;
import com.nacho.hr.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(value = "http://localhost:3000")
public class EmpoyeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpoyeeController.class);

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        LOGGER.info("Getting all employees");
        return employeeService.getAllEmployees();
    }

    // localhost:8080/employee
}
