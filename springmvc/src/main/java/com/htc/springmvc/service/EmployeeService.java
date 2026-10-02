package com.htc.springmvc.service;

import java.util.List;

import com.htc.springmvc.model.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee emp) ;
	public boolean addEmployee(int empno, String ename, String job, double salary);
	public Employee getEmployee(int empno) ;
	public List<Employee> getEmployees();
	public boolean deleteEmployee(int empno);
	public boolean updateEmployee(Employee newemp);

}
