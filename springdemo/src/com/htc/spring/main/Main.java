package com.htc.spring.main;



//import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.htc.spring.beans.Address;
import com.htc.spring.beans.Customer;

public class Main {
		public static void main(String[] args) {
			//Logger logger = Logger.getLogger(Main.class.getName());
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			
			Customer customer = (Customer) context.getBean("customer");
			Address address = (Address) context.getBean("address");
			Customer customer1 = (Customer) context.getBean("customer1");
			System.out.println(customer);
			System.out.println(address);
			System.out.println(customer1.getAddress().getCity());
			
//			logger.info(customer);
//			logger.info(customer1);
		}
}
