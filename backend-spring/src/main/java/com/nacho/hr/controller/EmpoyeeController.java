package com.nacho.hr.controller;

import com.nacho.hr.model.Employee;
import com.nacho.hr.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        LOGGER.info("Getting employee by id: " + id);
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        LOGGER.info("Adding employee: " + employee);
        return employeeService.addOrUpdateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEmployee(@PathVariable Integer id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            LOGGER.error("Employee with id " + id + " not found");
            return ResponseEntity.notFound().build().hasBody();
        }
        LOGGER.info("Deleting employee by id: " + id);
        employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response).hasBody();
    }
}
