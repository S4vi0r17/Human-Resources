package com.nacho.hr.service;

import com.nacho.hr.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Integer id);
    public Employee addOrUpdateEmployee(Employee employee);
    public void deleteEmployee(Integer id);
}
