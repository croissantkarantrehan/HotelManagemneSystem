package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="guest_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HotelGuest {
	@Id
	@GeneratedValue(generator = "GuestSeq")
	@SequenceGenerator(name = "guest_seq",sequenceName = "GuestSeq",allocationSize = 1)
	private long id;
	
	private String fullName;
	private String firstName;
	private String lastName;
	private String contactNo;
	private String emailId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public HotelGuest(long id, String fullName, String firstName, String lastName, String contactNo, String emailId) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.emailId = emailId;
	}
	public HotelGuest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
