package com.htc.spring.beans;

public class Address {
	private String doorno;
	private String street;
	private String city;
	private String pincode;
	public Address() {
		super();
	}
	public Address(String doorno, String street, String city, String pincode) {
		super();
		this.doorno = doorno;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
	public String getDoorno() {
		return doorno;
	}
	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [doorno=" + doorno + ", street=" + street + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	

}
