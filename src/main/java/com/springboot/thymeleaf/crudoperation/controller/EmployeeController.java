package com.springboot.thymeleaf.crudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.thymeleaf.crudoperation.model.Employee;
import com.springboot.thymeleaf.crudoperation.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("/")
	public String employees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees",employees);
		
		//adding new user
		model.addAttribute("employee",new Employee());
		//adding title dynamically
		model.addAttribute("title","Employees");
		
		model.addAttribute("isAdd",true);
		
		return "view/employees";
	}
	
}
