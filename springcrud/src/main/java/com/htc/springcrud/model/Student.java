package com.htc.springcrud.model;

public class Student {
	
	
	private String namee;
	private String gender;
	private String department;
	private String hobby;
	
	public Student(String namee, String gender, String department, String hobby) {
		super();
		this.namee = namee;
		this.gender = gender;
		this.department = department;
		this.hobby = hobby;
	}

	public Student() {}
	
	public String getNamee() {
		return namee;
	}

	public void setNamee(String namee) {
		this.namee = namee;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	@Override
	public String toString() {
		return "Student [namee=" + namee + ", gender=" + gender + ", department=" + department + ", hobby=" + hobby
				+ "]";
	}
	

}
