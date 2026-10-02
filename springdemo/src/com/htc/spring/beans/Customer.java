package com.htc.spring.beans;

public class Customer {
	
	private String custname;
	private String contactno;
	private Address address;
	public Customer() {
		super();
	}
	public Customer(String custname, String contactno, Address address) {
		super();
		this.custname = custname;
		this.contactno = contactno;
		this.address = address;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [custname=" + custname + ", contactno=" + contactno + "]";
	}
	
	

}
