package com.employee.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/empdata")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return employeeservice.createEmployee(employee);
	}
	
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return employeeservice.getAllEmployee();
    }
	
	
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeservice.deleteEmployee(id);
    }
    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeservice.getEmployee(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return employeeservice.updateEmployee(id, updatedEmployee);
    }
}
