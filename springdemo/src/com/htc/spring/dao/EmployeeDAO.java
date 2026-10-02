package com.htc.spring.dao;

import java.util.List;

import com.htc.spring.beans.Employee;

public interface EmployeeDAO {
	public boolean addEmployee(Employee emp);
	public boolean addEmployee(int empno,String empname,String job,double salary);
	public boolean deleteEmployee(int empno);
	public boolean updataEmployee(Employee newemp);
	public Employee getEmployee(int empno);
	public List<Employee> getAllEmployees();

}
