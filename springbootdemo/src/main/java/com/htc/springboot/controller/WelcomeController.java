package com.htc.springboot.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String WelcomePage(Model model ) {
		System.out.println(" Request Reached");
		model.addAttribute("user", getPrincipal());
		return "index";
	}
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
            System.out.println("UserName = "+userName);
        } else {
            userName = principal.toString();
            System.out.println("EUserName = "+userName);
        }
        return userName;
    }

	
	
	
	

}
