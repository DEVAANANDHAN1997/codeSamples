package com.htc.springcrud.dao;

import java.util.List;

import com.htc.springcrud.model.Student;

public interface StudentDAO {
	
	public boolean createStudent(Student stu);
	public boolean updateStudent(Student stud);
	public boolean deleteStudent(String name);
	public Student getStudentById(String name);
	public List<Student> readStudent();

}
