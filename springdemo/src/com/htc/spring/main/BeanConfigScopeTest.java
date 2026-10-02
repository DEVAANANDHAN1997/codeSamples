package com.htc.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.htc.spring.beans.Customer;
import com.htc.spring.config.BeansConfig;

public class BeanConfigScopeTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		
		
		Customer customer1 = (Customer) context.getBean("customer");
		//System.out.println(customer1);
		customer1.getAddress().setCity("Banglore");
		System.out.println(customer1.getAddress());
		
		Customer customer2 = (Customer) context.getBean("customer2");
		//System.out.println(customer2);
		
		System.out.println(customer2.getAddress());
	}

}
