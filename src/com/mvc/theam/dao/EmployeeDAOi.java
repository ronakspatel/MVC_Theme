package com.mvc.theam.dao;

import java.util.List;

import com.mvc.theam.model.Employee;

public interface EmployeeDAOi {
	
	public int getEmpId();
	public int addEmployee(Employee e);
	public List<Employee> getEmployee();
	public Employee viewEmployee(int hid);
	public int updateEmployee(Employee e);
	public int deleteEmployee(int hid);
}
