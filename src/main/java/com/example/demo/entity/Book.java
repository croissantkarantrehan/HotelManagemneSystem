package com.example.demo.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
	@Id
	@GeneratedValue(generator = "BookingSeq")
	@SequenceGenerator(name="booking_seq",sequenceName = "BookingSeq",allocationSize = 2)
	private long bookingId;
	private Timestamp checkInTime;
	private Timestamp checkOutTime;
	private Timestamp bookingDate;
	private Float totalPrice;
	@ManyToOne(fetch = FetchType.LAZY,cascade ={CascadeType.MERGE})
	@JoinColumn(name="room_id")
	@JsonBackReference
	private Room room;
	@ManyToOne(fetch = FetchType.LAZY,cascade ={CascadeType.MERGE})
	@JoinColumn(name="guest_id")
	private HotelGuest Guest;
	private String stayDuration;
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public Timestamp getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Timestamp checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Timestamp getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(Timestamp checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public Timestamp getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

	public HotelGuest getGuest() {
		return Guest;
	}
	public void setGuest(HotelGuest guest) {
		Guest = guest;
	}
	public String getStayDuration() {
		return stayDuration;
	}
	public void setStayDuration(String stayDuration) {
		this.stayDuration = stayDuration;
	}
	public Book(long bookingId, Timestamp checkInTime, Timestamp checkOutTime, Timestamp bookingDate, Float totalPrice,
			Room room, HotelGuest guest, String stayDuration) {
		super();
		this.bookingId = bookingId;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.bookingDate = bookingDate;
		this.totalPrice = totalPrice;
		//this.room = room;
		Guest = guest;
		this.stayDuration = stayDuration;
	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
}
