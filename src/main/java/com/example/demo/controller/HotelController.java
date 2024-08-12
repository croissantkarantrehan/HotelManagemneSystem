package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HotelData;
import com.example.demo.repo.BookingRepo;
import com.example.demo.repo.HotelDataRepo;
import com.example.demo.repo.HotelRepo;

@RequestMapping(path="hotel")
@RestController
public class HotelController {
	@Autowired
	HotelRepo hotelRepo;
	
	
	@Autowired
	BookingRepo bookingRepo;
	
	
	
	@PostMapping(path="/add")
	public HotelData addHotel(@RequestBody HotelData hotelDataObj)
	{
		return hotelRepo.save(hotelDataObj);
		
	}

	@PostMapping(path="HotelData")
	public void addHotelData(@RequestBody HotelData hotelData)
	{
		System.out.println("1---------------------");
		HotelData HotelDatal= hotelRepo.save(hotelData);

		
	}
	

}
