package com.htc.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.htc.springcrud.dao.StudentDAO;
import com.htc.springcrud.model.Student;

@Controller
public class StudentController {
	
	@Autowired 
	StudentDAO studentDao;
	
	@GetMapping(value = "/")
	public String WelcomePage() {
		System.out.println("Welcome Page");
		return "index";
	}
	
	@GetMapping(value = "/addStudent")
	public String StudentForm(Model model) {
		model.addAttribute("student",new Student());
		System.out.println("Student Form Page");
		return "addstudent";
	}
	
	@PostMapping(value = "/create")
	public String createStudent(@ModelAttribute(name = "student")Student student) {
		System.out.println(student.toString());
		boolean result = studentDao.createStudent(student);
		System.out.println(result);
		return "student_confirmation";
		
	}
	@GetMapping(value = "/listStudent")
	public String listStudent(Model model) {
		List<Student> student_list = studentDao.readStudent();
		model.addAttribute("student_list",student_list);
		return "list_students";
	}
	
	@GetMapping(value = "/deletestudent/{name}")
	public String delteStudent(@PathVariable String name) {
		studentDao.deleteStudent(name);
		return "redirect:/list_student";
	}
	
	@GetMapping(value = "updatestudent/{name}")
	public String updateStudent(@PathVariable String name,Model model) {
		Student student = studentDao.getStudentById(name);
		 
		model.addAttribute("command",student);
		return "student_edit_form";
	}
	
	
	@RequestMapping(value="/Editstudent",method = RequestMethod.POST)    
	public String updateStudent(@ModelAttribute(name = "command")Student student) {
		
		System.out.println(student.toString());
		boolean result = studentDao.updateStudent(student);
		System.out.println(result);
		return "redirect:/listStudent";
		
	}
	
}
