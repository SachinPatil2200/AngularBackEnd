package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Employee;
import com.jbk.service.EmployeeService;

@RestController
public class EmployeeController1 {
@Autowired

EmployeeService service;

	@GetMapping("/getEmp/{id}")
	public  ResponseEntity<?> getEmp(@PathVariable int id) {
		
		Employee e=service.getEmployeeById(id);
	return new ResponseEntity<Employee>(e,HttpStatus.FOUND);
	}
}
