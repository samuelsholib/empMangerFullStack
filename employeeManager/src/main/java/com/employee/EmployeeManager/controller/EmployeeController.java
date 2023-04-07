package com.employee.EmployeeManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeManager.service.EmployeeService;
import com.employee.EmployeeManager.entity.Employee;
import ch.qos.logback.core.model.Model;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//http://localhost:8080/getEmployee/1
		@GetMapping("/getEmployee/{id}")
		public Employee getEmployee(@PathVariable Long id) {
			System.out.println(id);
			
			return employeeService.getEmployeeById(id);
		}
	//http://localhost:8080/addEmployee
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);
	}

	
	//http://localhost:8080/employee/username
	@GetMapping("/employee")
	public boolean getEmployeeByUsername(@RequestParam String username) {

		return employeeService.getEmployeeByUsername(username);
	}
	
	//http://localhost:8080/getAllEmployees
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();
	}
	
	//http://localhost:8080/updateEmployee
	@PutMapping("/updateEmployee")
	public void updateEmployee(@RequestBody Employee employee) {
		
		employeeService.updateEmployee(employee);
	}
	
	//http://localhost:8080/deleteEmployee
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		
		employeeService.deleteEmployee(id);
	}
	
}

