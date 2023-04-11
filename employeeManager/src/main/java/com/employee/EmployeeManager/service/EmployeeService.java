package com.employee.EmployeeManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.EmployeeManager.entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Long id);

	Employee addEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);

	}
