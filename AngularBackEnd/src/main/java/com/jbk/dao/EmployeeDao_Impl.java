package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Employee;

@Repository
public class EmployeeDao_Impl implements EmployeeDao {
	@Autowired
	SessionFactory factory;

	@Override
	public Employee saveEmployee(Employee employee) {
		Session s = factory.openSession();
		Transaction tt = s.beginTransaction();
		try {
			s.save(employee);
			tt.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			s.close();
		}
		return employee;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Session s=factory.openSession();
		Employee emp;
	try {
		 emp=s.get(Employee.class,employeeId );
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}finally {
		s.close();
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
	Session s=	factory.openSession();
	List<Employee> list;
	try {
		Criteria crt=s.createCriteria(Employee.class);
		list=crt.list();
		
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}finally {
		s.close();
	}
		return list;
	}

	@Override
	public boolean deleteEmployeeById(int employeeId) {
		Session s=  factory.openSession();
	Transaction tt=	s.beginTransaction();
	try {
		Employee emp=s.get(Employee.class,employeeId );
		System.out.println(emp);
		s.remove(emp);
		tt.commit();
	} catch (Exception e) {
		return false;
	}finally {
		s.clear();
	}
	return true;
	}

	@Override
	public Employee updatEmployee(Employee employee) {
		Session s = factory.openSession();
		Transaction tt = s.beginTransaction();
		try {
			s.update(employee);
			tt.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			s.close();
		}
		return employee;
	}

}
