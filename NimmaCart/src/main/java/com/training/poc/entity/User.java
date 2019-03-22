package com.training.poc.entity;

import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	private String firstName;
	private String lastName;
	@Id
	private String phoneNo;
	private String emailId;
	private String password;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String firstName, String lastName, String phoneNumber, String emailId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNumber;
		this.emailId = emailId;
		this.password = password;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNo;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNo = phoneNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNo + ", emailId="
				+ emailId + ", password=" + password + "]";
	}
	
	
	

}
