package com.htc.springmvc.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler
	public ModelAndView handleExeception(Exception ex) {
		ModelAndView mv = new ModelAndView("error","errorMsg",ex.getMessage());
		return mv;
	}

}
