package com.employee.EmployeeManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.EmployeeManager.entity.Employee;

@Service
public interface EmployeeService {

	// To get all employees
	public List<Employee> getAllEmployees();

	Employee addEmployee(Employee employee);
}
