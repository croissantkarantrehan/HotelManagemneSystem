//package com.example.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entity.HotelRoom;
//import com.example.demo.repo.RoomRepo;
//import com.example.demo.repo.RoomTypeRepo;
//
//@RestController
//public class HomeController {
//@Autowired
//private RoomRepo roomRepo;
//@Autowired
//private RoomTypeRepo roomTypeRepo;
//
//
//@PostMapping(path ="/addroom")
//public HotelRoom adddroom(@RequestBody HotelRoom obj)
//{System.out.println(obj.getType());
//	return roomRepo.save(obj);
//	
//}
//}
