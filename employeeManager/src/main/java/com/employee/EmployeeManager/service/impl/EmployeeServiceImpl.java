package com.employee.EmployeeManager.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeManager.entity.Employee;
import com.employee.EmployeeManager.repository.EmployeeRepository;

import com.employee.EmployeeManager.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository repository; 
	
	
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		employee.setRegistrationDate(LocalDate.now());
		employee.setLastLogin(LocalDateTime.now());
		return repository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		Optional<Employee> employee = repository.findById(id);
		
		if(employee.isEmpty()) {
			return null;
			
		} else {
			return employee.get();
		}
	}

	@Override
	public boolean getEmployeeByUsername(String username) {
		
		return repository.findEmployeeByUsernameIgnoreCase(username) != null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return (List<Employee>)repository.findAll();
	}

	@Override
	public void updateEmployee(Employee employeeUpdate) {
		Optional<Employee> employeeFound = repository.findById(employeeUpdate.getId());
		System.out.println(employeeFound);
		if ( employeeFound.isPresent() ) {
			Employee employee = employeeFound.get();
			employee.setEmail(employeeUpdate.getEmail());
			employee.setFirstName(employeeUpdate.getFirstName());
			employee.setLastName(employeeUpdate.getLastName());
			
			repository.save(employee);
		}
		
	}

	@Override
	public void deleteEmployee(Long id) {
		
		if(repository.existsById(id)) {
			Employee employee = repository.findById(id).get();
			repository.delete(employee);
		}

	}

}

