package com.example.demo.entity.dto;

public class AvailableRoom {
	private String startDate;
private String endDate;
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public AvailableRoom() {
	super();
	// TODO Auto-generated constructor stub
}
public AvailableRoom(String startDate, String endDate) {
	super();
	this.startDate = startDate;
	this.endDate = endDate;
}
}
