package com.employee.EmployeeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.EmployeeManager.entity.Employee;
import com.employee.EmployeeManager.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);
		System.out.println("App is running");
	}
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Employee emp1 = new Employee("Yacob", "Dejene", "jacob@jmail.com");
//		employeeRepository.save(emp1);
//		
//		Employee emp2 = new Employee("Ermiyas", "Dejene", "ermi@jmail.com");
//		employeeRepository.save(emp2);
		
//		Employee emp3 = new Employee("Ammanuel", "Dejene", "aman@jmail.com");
//		employeeRepository.save(emp3);
//		
//		Employee emp4 = new Employee("Dinku", "Dejene", "dinku@jmail.com");
//		employeeRepository.save(emp4);
//		
	}

}
