package com.employee.EmployeeManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.EmployeeManager.entity.Employee;

@Service
public interface EmployeeService {

	// To post new Employee
    public Employee addEmployee(Employee employee);

    // To find single employee by empID
    Employee getEmployeeById(Long id);

    // To find Employee by username
    public boolean getEmployeeByUsername(String username);

    // To get all employees
    public List<Employee> getAllEmployees();

    // To update employee
    public void updateEmployee(Employee employee);

    // To employee from employee list
    void deleteEmployee(Long id);


}

