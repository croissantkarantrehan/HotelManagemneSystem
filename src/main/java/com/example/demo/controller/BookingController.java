package com.example.demo.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.entity.HotelGuest;
import com.example.demo.entity.Room;
import com.example.demo.entity.dto.AvailableRoom;
import com.example.demo.entity.dto.roomDto;
import com.example.demo.repo.BookingRepo;
import com.example.demo.repo.GuestRepo;
import com.example.demo.repo.RoomRepo;

@RestController
@RequestMapping(value="/Booking")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {
	
	@Autowired
	BookingRepo BookRepo;
	

	
	
	@PostMapping(path="/addBooking")
	public Book Book(@RequestBody Book BookObj) throws ParseException
	{
		 
		Timestamp checkOutTime= BookObj.getCheckOutTime();
		Timestamp checkInTime= BookObj.getCheckInTime();
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		java.util.Date l1=sdf.parse(checkOutTime.toString());
		java.util.Date l2=sdf.parse(checkInTime.toString());

		long difference_In_Time
        = checkOutTime.getTime()-checkInTime.getTime();

    
    long difference_In_Seconds
        = (difference_In_Time
           / 1000)
          % 60;

    long difference_In_Minutes
        = (difference_In_Time
           / (1000 * 60))
          % 60;

    long difference_In_Hours
        = (difference_In_Time
           / (1000 * 60 * 60))
          % 24;

    long difference_In_Years
        = (difference_In_Time
           / (1000l * 60 * 60 * 24 * 365));

    long difference_In_Days
        = (difference_In_Time
           / (1000 * 60 * 60 * 24))
          % 365;

    // Print the date difference in
    // years, in days, in hours, in
    // minutes, and in seconds

    System.out.print(
        "Difference "
        + "between two dates is: ");

    System.out.println(
        difference_In_Years
        + " years, "
        + difference_In_Days
        + " days, "
        + difference_In_Hours
        + " hours, "
        + difference_In_Minutes
        + " minutes, "
        + difference_In_Seconds
        + " seconds");
    
    String stayduration=String.valueOf(difference_In_Years)+"-"+String.valueOf(difference_In_Days)+"-"+String.valueOf(difference_In_Hours)+"-"+String.valueOf(difference_In_Minutes)+"-"+String.valueOf(difference_In_Seconds);
	System.out.println(stayduration);	
	BookObj.setStayDuration(stayduration);
    return BookRepo.save(BookObj);
		
	}
	
	
	@GetMapping(path="/getBooking")
	public List<Book> getBook()
	{
		return  BookRepo.findAll();
	}
	
	

	
	
	
	
}
