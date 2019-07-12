package com.springboot.thymeleaf.crudoperation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.thymeleaf.crudoperation.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
}
