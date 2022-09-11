package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Employee;
import com.jbk.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping(value="/in")
	public String in() {
		return "Welcome";
	}
	
	
	
	

	@PostMapping(value = "/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		System.out.println(emp);

		Employee employee = service.saveEmployee(emp);

		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);

		}

		return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping(value="/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
	Employee emp=service.getEmployeeById(id);
	if(emp!=null) {
		System.out.println("===="+emp);
	return new	ResponseEntity<Employee>(emp,HttpStatus.FOUND);
	}
	else 
		return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
	List<Employee> list=	service.getAllEmployee();
	if(list!=null) {
		return new ResponseEntity<List<Employee>>(list,HttpStatus.FOUND);
	}
	else 
		return new  ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
				
		
	}

	@DeleteMapping(value="/deleteEmployeeById/{eid}") 
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int eid){
		boolean bl=service.deleteEmployeeById(eid);
		if(bl) {
			return new ResponseEntity<String>("Successfully Deleted...!",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Something Went To Wrong...!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		System.out.println(emp);

		Employee employee = service.saveEmployee(emp);

		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);

		}

		return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
}
