package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepo;
import com.employee.model.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		System.out.println("E-save");
		return employeeRepository.save(employee);
	}

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }



    @Override
    public void deleteEmployee(int id) {

        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

 

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        return employeeRepository.findById(id).map(existingEmployee -> {
            existingEmployee.setName(employee.getName());
            existingEmployee.setSalary(employee.getSalary());

 

            return employeeRepository.save(existingEmployee);
        }).orElse(null);
    }

}
