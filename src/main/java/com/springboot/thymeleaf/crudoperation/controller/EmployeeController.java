package com.springboot.thymeleaf.crudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.thymeleaf.crudoperation.model.Employee;
import com.springboot.thymeleaf.crudoperation.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("/")
	public String employees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		//client side obj
		model.addAttribute("employees",employees);
		
		//adding new user
		model.addAttribute("employee",new Employee());
		//adding title dynamically
		model.addAttribute("title","Employees");
		
		model.addAttribute("isAdd",true);
		
		return "view/employees";
	}
	
	@PostMapping(value="/save")
	public String save(@ModelAttribute Employee employee,RedirectAttributes redirectAttributes,Model model) {
		Employee dbEmployee = employeeService.save(employee);
		if(dbEmployee!=null) {
			redirectAttributes.addFlashAttribute("succesmessage","Employee save succesfuly!");
			return "redirect:/";
		}else {
			model.addAttribute("errormessage","Employee is not save, please try again.");
			model.addAttribute("employee",employee);
			return "view/employees";
		}
	}
	
	@GetMapping(value="/getEmployee/{id}")
	public String getEmployee(@PathVariable Long id, Model model) {
		
		Employee employee = employeeService.findById(id);
		List<Employee> employees = employeeService.getAllEmployees();
		//client side obj
		model.addAttribute("employees",employees);
		model.addAttribute("employee",employee);
		
		model.addAttribute("title","Edit Employees");
		
		model.addAttribute("isAdd",false);
		
		return "view/employees";
	}
	
	@PostMapping(value="/update")
	public String update(@ModelAttribute Employee employee,RedirectAttributes redirectAttributes,Model model) {
		Employee dbEmployee = employeeService.update(employee);
		if(dbEmployee!=null) {
			redirectAttributes.addFlashAttribute("succesmessage","Employee updated succesfuly!");
			return "redirect:/";
		}else {
			model.addAttribute("errormessage","Employee is not update, please try again.");
			model.addAttribute("employee",employee);
			return "view/employees";
		}
	}
	
	@GetMapping(value="/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id,RedirectAttributes redirectAttributes) {
		
		employeeService.delete(id);
		
		redirectAttributes.addFlashAttribute("succesmessage","Employee deleted succesfuly!");
		return "redirect:/";
	}
}
