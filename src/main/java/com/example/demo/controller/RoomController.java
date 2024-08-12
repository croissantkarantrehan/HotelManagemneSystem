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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HotelData;
import com.example.demo.entity.HotelGuest;
import com.example.demo.entity.Room;
import com.example.demo.entity.RoomType;
import com.example.demo.entity.dto.AvailableRoom;
import com.example.demo.entity.dto.roomDto;
import com.example.demo.repo.BookingRepo;
import com.example.demo.repo.GuestRepo;
import com.example.demo.repo.HotelDataRepo;
import com.example.demo.repo.RoomRepo;
import com.example.demo.repo.RoomTypeRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping(path="/Room")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ControllerAdvice
public class RoomController {
	
	
	
	@Autowired
	RoomRepo roomRepo;
	
	@Autowired
	RoomTypeRepo roomTypeRepo;
	
	@Autowired
	GuestRepo guestRepo;
	
	@Autowired
	HotelDataRepo hotelDataRepo;
	
	@Autowired
	BookingRepo bookingRepo;
	
	
	

	
	
	 @PersistenceContext
	 private EntityManager entityManager;
	
	@PostMapping(path="/addroom")
	public Room addRoom(@RequestBody Room room)
	{
		return roomRepo.save(room);
		
	}
	
	

	
	@PostMapping(path="/addRoomType")
	public void addRoomType(@RequestBody RoomType roomType)
	{
		System.out.println("1---------------------");
		RoomType roomTypeObj= roomTypeRepo.save(roomType);

		
	}
	
	
	
	@PostMapping(path="/availableRoom")
	public ResponseEntity<?> getAvailableRoomByType(@RequestBody AvailableRoom availableRooms) throws ParseException
	{ 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date EndDate= sdf.parse(availableRooms.getEndDate());
		java.util.Date StartDate= sdf.parse(availableRooms.getStartDate());
System.out.println(availableRooms.getStartDate());
		Timestamp endDate=new Timestamp(EndDate.getTime());
		Timestamp startDate=new Timestamp(StartDate.getTime());
		
		System.out.println(startDate);
		System.out.println(endDate);

		HashMap<String,List<roomDto>> hashMapOfRoomAvailable=new HashMap<String,List<roomDto>>();
		List<Integer> listOfBookedRoom=bookingRepo.findAllBookedRoom(startDate,endDate);
		List<roomDto> listOfRoom=new ArrayList <roomDto>();
		
		if(!listOfBookedRoom.isEmpty())
		{listOfRoom=roomRepo.fetchRoomNotInList(listOfBookedRoom);}
		else
			listOfRoom=roomRepo.fetchAllRoomRoomType();
			
		
		for(roomDto item:listOfRoom)
		{
			if(!hashMapOfRoomAvailable.containsKey(item.getRoomType()))
				{
					List<roomDto> ls=new ArrayList<roomDto>();
				ls.add(item);
					hashMapOfRoomAvailable.put(item.getRoomType(), ls);
					
				}
			else if(hashMapOfRoomAvailable.containsKey(item.getRoomType())
					&&(!hashMapOfRoomAvailable.get(item.getRoomType()).contains(item.getRoomId())))
			{
				List<roomDto> ls=hashMapOfRoomAvailable.get(item.getRoomType());
				ls.add(item);
				
					hashMapOfRoomAvailable.put(item.getRoomType(), ls);
					
			}
		}
		
		return ResponseEntity.ok(hashMapOfRoomAvailable);


	}
	
	
	@GetMapping(path="/getRoomList")
	public List<Room> getRoom()
	{
		 List<Room> ls=roomRepo.findAll();
		 System.out.println("hhh");
//		System.out.println( ls.get(0).getBook());
	List <Room> testList=ls.stream().map(x->x.RoomDto(x)).collect(Collectors.toList());
		 return testList;
//		return roomRepo.findAll();
	}


}
