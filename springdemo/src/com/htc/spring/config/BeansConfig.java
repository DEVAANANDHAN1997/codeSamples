package com.htc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.htc.spring.beans.Address;
import com.htc.spring.beans.Customer;

@Configuration
public class BeansConfig {
	
	
	@Bean(name="customer")
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setCustname("cust1beansconfig");
		customer.setContactno("00000000000");
		customer.setAddress(getAddress());
		return customer;
	}
	
	@Bean(name="customer2")
	public Customer getCustomer2() {
		Customer customer = new Customer();
		customer.setCustname("cust1beansconfig");
		customer.setContactno("00000000000");
		customer.setAddress(getAddress());
		return customer;
	}
	
	
	@Bean(name="address")
	@Scope(scopeName = "prototype")
	public Address getAddress() {
		Address address = new Address();
		address.setDoorno("312");
		address.setCity("chennai");
		address.setStreet("streetbeanconfig");
		address.setPincode("654323");
		return address;
	}
}

