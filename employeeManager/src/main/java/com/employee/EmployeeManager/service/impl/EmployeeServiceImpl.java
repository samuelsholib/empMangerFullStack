package com.employee.EmployeeManager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.EmployeeManager.entity.Employee;
import com.employee.EmployeeManager.repository.EmployeeRepository;
import com.employee.EmployeeManager.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	public Employee getEmployeeById(Long id) {
		
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	
	}


	
}