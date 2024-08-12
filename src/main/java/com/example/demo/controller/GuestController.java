package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HotelGuest;
import com.example.demo.repo.GuestRepo;


@RestController
@RequestMapping(path="/Guest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GuestController {

	@Autowired
	GuestRepo guestRepo;
	
	@GetMapping(path="/getGuestList")
	public List<HotelGuest> getGuest()
	{
		return guestRepo.findAll();
		
	}
	
	
	@PostMapping(path="/Guest")
	public HotelGuest addGuest(@RequestBody HotelGuest Guest)
	{
		return guestRepo.save(Guest);
		
	}
}
