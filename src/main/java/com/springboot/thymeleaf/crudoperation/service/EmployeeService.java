package com.springboot.thymeleaf.crudoperation.service;

import java.util.List;

import com.springboot.thymeleaf.crudoperation.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee save(Employee employee);

	Employee findById(Long id);

	Employee update(Employee employee);

	void delete(Long id);
	
}
