package com.jbk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import com.jbk.controller.EmployeeController;
import com.jbk.dao.EmployeeDao;
import com.jbk.entity.Country;
import com.jbk.entity.Employee;
import com.jbk.service.EmployeeService;
import com.jbk.service.EmployeeService_Impl;

@SpringBootTest
public class EmployeeControllerTestByMocking {

	@InjectMocks
	EmployeeController ec;
	@InjectMocks
	EmployeeService_Impl impl; 

	@Mock
	EmployeeService service;
	@Mock
	EmployeeDao dao;

	@Test
	public void Contlr_getEmployeeByIdTest() {
		when(service.getEmployeeById(1)).thenReturn(getEmpStub());
		
		ResponseEntity<Employee> emp=ec.getEmployeeById(1);
		assertEquals(302,emp.getStatusCodeValue());
		
	}

	
	  @Test public void service_getEmployeeByIdTest() {
	  when(dao.getEmployeeById(1)).thenReturn(getEmpStub());
	  
	  Employee emp=impl.getEmployeeById(1); 
	  assertEquals(emp.getName(),"KK");
	  
	  }
	 
	
	
	private Employee getEmpStub() {
		Employee e=Employee.builder().id(1).
		name("KK").mobNo("9096295555").emailId("sss@gmail.com").gender("Male")
		.department("IT").status("Inactive").createdDate(new Date()).updateDate(new Date())
		.updatedBy("sachin").country(Country.builder().cid(91).cname("India").build()).build();
		return e;
	}
}
/*
 * { "id": 1, "name": "sss", "mobNo": "9096295555", "emailId": "sss@gmail.com",
 * "gender": "Male", "department": "IT", "status": "Inactive", "createdDate":
 * "2022-06-06T04:42:04.000+00:00", "createdBy": "sachin", "updateDate":
 * "2022-06-06T04:42:04.000+00:00", "updatedBy": "sachin", "country": { "cname":
 * "India", "cid": 91 } }
 */
