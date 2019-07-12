package com.springboot.thymeleaf.crudoperation.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.thymeleaf.crudoperation.model.Employee;
import com.springboot.thymeleaf.crudoperation.repository.EmployeeRepository;
import com.springboot.thymeleaf.crudoperation.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

}
