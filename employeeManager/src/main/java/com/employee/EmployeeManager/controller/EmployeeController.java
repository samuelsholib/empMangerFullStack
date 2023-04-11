package com.employee.EmployeeManager.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		// initialize new Employee Object to hold new Employee data.
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "add_employee";
		
	}
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}
	@GetMapping("employees/update/{id}")
	public String updateEmployee(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "update_employee";
		
	}
	@PostMapping("/employees/{id}")
	public String editEmployee(@PathVariable Long id, @ModelAttribute ("employee") Employee employee, Model model) {
		
		// To get employee from database byId
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName((employee.getFirstName()));
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		// To save updated employee data to DB
		employeeService.updateEmployee(existingEmployee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
		
	}

}