package com.htc.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.htc.spring.beans.Employee;
import com.htc.spring.dao.EmployeeDAO;

public class JDBC {
	public static void main(String[] args) {
		ApplicationContext context = new  ClassPathXmlApplicationContext("jdbc.xml");
		Employee e;
		EmployeeDAO dao = (EmployeeDAO) context.getBean("employeeDAO");
		System.out.println("Inserting records");
//		boolean result = dao.addEmployee(new Employee(101,"John","Designer",53200.0));
//		dao.addEmployee(new Employee(102,"Robert","Developer",32200.0));
//		System.out.println("Retrieving records");
//		try {
//			System.out.println(dao.getEmployee(102));
//		}
//		catch(DataAccessException ex) {
//			System.out.println("Employee doesn;t exist");
//		}
//		System.out.println("Updating Records");
//		dao.updataEmployee(new Employee(101,"John","Designer",000000.0));
//		System.out.println("Updating Records");
		System.out.println(dao.getAllEmployees());
		for(Employee emp:dao.getAllEmployees())
		{
			System.out.println();
		}
//		System.out.println("Deleting Records");
//		dao.deleteEmployee(101);
	}

}
