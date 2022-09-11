package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.EmployeeDao;
import com.jbk.entity.Employee;

@Service
public class EmployeeService_Impl implements EmployeeService {
@Autowired
private EmployeeDao dao;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee emp=dao.saveEmployee(employee);
		return emp;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		System.out.println("*******************8*8*");
		Employee emp=dao.getEmployeeById(employeeId);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=dao.getAllEmployee();
		return list;
	}

	@Override
	public boolean deleteEmployeeById(int employeeId) {
		boolean bl=dao.deleteEmployeeById(employeeId);		
		return bl;
	}

	@Override
	public Employee updatEmployee(Employee employee) {
		Employee emp=dao.updatEmployee(employee);
		return emp;
	}

}
