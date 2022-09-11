package com.jbk.service;

import java.util.List;

import com.jbk.entity.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);

	public Employee getEmployeeById(int employeeId);

	public List<Employee> getAllEmployee();

	public boolean deleteEmployeeById(int employeeId);

	public Employee updatEmployee(Employee employee);

}
