package com.htc.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.htc.springmvc.model.Employee;
import com.htc.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/employeeForm")
	public String showEmployeeForm(Model model) {
		model.addAttribute("emp",new Employee());
		return "employeeForm";
	}
	
	@PostMapping(value = "/addEmployee")
	public String addEmployee(@ModelAttribute(name = "emp")Employee emp,RedirectAttributes attrs) {
		System.out.println(emp.toString());
		boolean result = empService.addEmployee(emp);
		System.out.println(result);
		if(result) {
			attrs.addFlashAttribute("empname",emp.getEname());
			return "redirect:/empSuccess";
			//return "addEmpSuccess";   //RequestDispatcher.forward(req, res);
			}
		else {
			return "employeeForm";
			//throw new RuntimeException(" Testing Exception handling in Spring");
			}
				
	}
	
	
	
	@GetMapping("/empSuccess")
	public String addEmpSuccess() {
		return "addEmployeeSuccess";
	}
	
	
	@PostMapping(value = "/updateEmp")
	public String updataEmployee(@ModelAttribute(name = "emp")Employee emp,RedirectAttributes attrs) {
		System.out.println(emp.toString());
		System.out.println(emp);
		boolean result = empService.updateEmployee(emp);
		System.out.println(result);
		if(result) {
			//attrs.addFlashAttribute("empname",emp.getEname());
			return "redirect:/listEmps";
			//return "addEmpSuccess";   //RequestDispatcher.forward(req, res);
			}
		else {
			return "employeeForm";
			//throw new RuntimeException(" Testing Exception handling in Spring");
			}
				
	}
	@RequestMapping(value = "/deleteemp/{empno}",method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable(name="empno") int empno) {
		System.out.println(empno);
		boolean result =empService.deleteEmployee(empno);
		System.out.println(result);
		return "redirect:/listEmps";
	}
	
	@RequestMapping(value="/searchEmpForm", method=RequestMethod.GET)
	public ModelAndView searchEmpForm() {
		ModelAndView mv = new ModelAndView("searchEmpForm", "emp", new Employee());
		return mv;
	}
	@RequestMapping(value = "/listEmps",method = RequestMethod.GET)
	public ModelAndView listUsers() {
		List<Employee> empList = empService.getEmployees();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listEmps");
		mv.addObject("empList",empList);
		return mv;
	}
	
	@GetMapping(value="/getEmployee", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee getEmployee(@RequestParam(name="empno") int empno) {    //@PathVariable(name="empno")
		
		System.out.println(empno);
		Employee emp = empService.getEmployee(empno);
		System.out.println(emp);
		System.out.println(emp.toString());
		return emp;
	}
	
	
	
	
//	public ModelAndView handleException(Exception ex) {
//		ModelAndView mv = new ModelAndView("error","errorMsg",ex.getMessage());
//		return mv;
//	}
	

}
