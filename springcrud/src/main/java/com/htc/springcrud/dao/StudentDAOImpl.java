package com.htc.springcrud.dao;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.htc.springcrud.model.Student;

public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean createStudent(Student stu) {
		//String sql = "insert into springstudent values(?,?,?,?)"+stu.getNamee()+stu.getGender()+stu.getDepartment()+stu.getHobby();
		//String sql = "insert into springstudent values(?,?,?,?)";
		
//		String[] spotname = stu.getHobby();						
		//String[] str_spotname = (String[]) spotname.getArray();	
		
//		System.out.println("spotname"+spotname);
//		System.out.println("str_spotname"+spotname);
		
		String sql = "insert into springstudent values('"+stu.getNamee()+"','"+stu.getGender()+"','"+stu.getDepartment()+"','"+stu.getHobby()+"')";
		//String sql = "insert into springstudent values('"+stu.getNamee()+"','"+stu.getGender()+"','"+stu.getDepartment()+"','"+spotname+"')";
		System.out.println(sql);
		//int result = jdbcTemplate.update(sql+stu.getNamee(),stu.getGender()+stu.getDepartment()+stu.getDepartment());
		int result = jdbcTemplate.update(sql);
		if(result>0)
			return true;
		return false;
	}

	public boolean updateStudent(Student stud) {
		String sql = "update springstudent set gender='"+stud.getGender()+"',department='"+stud.getDepartment()+"',hobby='"+stud.getHobby()+"' where namee='"+stud.getNamee()+"'";
		System.out.println(sql);
		int result = jdbcTemplate.update(sql);
		if(result>0)
			return true;
		return false;
	}

	public boolean deleteStudent(String name) {
		String sql = "delete from springstudent where namee='"+name+"'";
		System.out.println(sql);
		int result = jdbcTemplate.update(sql);
		if(result>0)
			return true;
		return false;
	}

	public Student getStudentById(String name) {
		String sql = "select namee,gender,department,hobby from springstudent where namee='"+name+"'";
		System.out.println(sql);
		Student stuobj = null;
		stuobj = jdbcTemplate.queryForObject(sql,new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setNamee(rs.getString(1));
				stu.setGender(rs.getString(2));
				stu.setDepartment(rs.getString(3));
//				String hobby = rs.getString(4);String[] name = null;
//				for(int i=0;i<3;i++) {
//					 name = hobby.split(",");
//					 }
//				stu.setHobby(name);System.out.println(name);
				stu.setHobby(rs.getString(4));
//				Array spotname = rs.getArray(4);	
//				String[] str_spotname = (String[]) spotname.getArray();	
//				
//				System.out.println("spotname"+spotname);
//				System.out.println("str_spotname"+str_spotname);
//				stu.setHobby(str_spotname);
//				for (String val : str_spotname) {
//					System.out.println(val);
//				}
				
				
				return stu;
			}
			
		});
		return stuobj;
	}

	public List<Student> readStudent() {
		String sql = "select namee,gender,department,hobby from springstudent";
		List<Student> studentlist = null;
		studentlist = jdbcTemplate.query(sql,new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setNamee(rs.getString(1));
				stu.setGender(rs.getString(2));
				stu.setDepartment(rs.getString(3));
				stu.setHobby(rs.getString(4));
				
//				Array spotname = rs.getArray(4);	
//				String[] str_spotname = (String[]) spotname.getArray();	
//				
//				System.out.println("spotname"+spotname);
//				System.out.println("str_spotname"+str_spotname);
//				stu.setHobby(str_spotname);
				return stu;
			}
			
		});
		return studentlist;
	}

}
