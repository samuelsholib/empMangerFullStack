package com.employee.EmployeeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.EmployeeManager.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
