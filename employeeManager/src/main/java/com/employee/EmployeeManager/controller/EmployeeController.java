package com.employee.EmployeeManager.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.EmployeeManager.entity.Employee;
import com.employee.EmployeeManager.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String retrieveEmployee(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());

		return "employees";

	}
	
	@GetMapping("/employees/new")
	public String addNewEmployee(Model model) {
		
		// initalize new Employee Object to hold new Employee data.
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "add_employee";
		
	}
	@PostMapping
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}

}