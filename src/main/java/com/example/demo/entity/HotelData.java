package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="hotel_data")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class HotelData {
	@Id
	@GeneratedValue(generator = "hotel_seq")
	@SequenceGenerator(name = "hotel_seq",sequenceName = "HOTEL_DATA_SEQ",allocationSize = 1)
	private long id;
	private String address;
	private String contactNo;
	private String email;
	private String stars;
	private String checkInTime;
	private String checkOutTime;
	public HotelData(String address, String contactNo, String email, String stars, String checkInTime,
			String checkOutTime) {
		super();
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.stars = stars;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}
	@Override
	public String toString() {
		return "HotelData [id=" + id + ", address=" + address + ", contactNo=" + contactNo + ", email=" + email
				+ ", stars=" + stars + ", checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime + "]";
	}
	public HotelData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	

}
