package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtUserDetails;
import com.example.demo.config.JwtUtil;
import com.example.demo.entity.UserTable;
import com.example.demo.entity.dto.LoginResponseDto;
import com.example.demo.repo.UserDetailsRepo;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",
methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.OPTIONS} )
public class LoginController {
	
	@Autowired 
	JwtUserDetails jwtUserDetails;
	
	@Autowired
	AuthenticationManager  authenticationManager;

	@Autowired
	JwtUtil jwtUtil;
	
	
	@Autowired 
	UserDetailsRepo userDetailsRepo;
	
//	@GetMapping(value="jwt")
//	public ResponseEntity<?> getJwtToken(@RequestBody UserTable user) {
//	
////		System.out.println("--"+name+" --"+"password");
//		if(authenticate(user))
//			{
//			UserDetails userDetails= jwtUserDetails.loadUserByUsername(user.getName());
//			LoginResponseDto response=new LoginResponseDto();
//		response.setToken("Bearer "+jwtUtil.GenerateToken(userDetails.getUsername()));
//		UserTable user1=userDetailsRepo.findByName(user.getName());
//			response.setRole(user1.getRole());
//return ResponseEntity.ok().body(response);		
//		}
//		return ResponseEntity.ok().body("Not Right Credeantial");
////		return ResponseEntity.ok().body("body");
//
//		
//	}
	
	@PostMapping(value="jwt")
	public ResponseEntity<?> putJwttoken(@RequestBody UserTable user) {
	
		System.out.println("psot");
		if(authenticate(user))
			{
			UserDetails userDetails= jwtUserDetails.loadUserByUsername(user.getName());
			LoginResponseDto response=new LoginResponseDto();
		response.setToken("Bearer "+jwtUtil.GenerateToken(userDetails.getUsername()));
		UserTable user1=userDetailsRepo.findByName(user.getName());
			response.setRole(user1.getRole());
return ResponseEntity.ok().body(response);		
		}
		return ResponseEntity.ok().body("Not Right Credeantial");
		
	}
//	
	public boolean authenticate(UserTable user) {
		try {			
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
return true;
		}
		catch(BadCredentialsException e)
		{
			e.printStackTrace();
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	@GetMapping(value="/hello")
	public String haha(@RequestBody UserTable user) {
		System.out.println("jjjj");
	return "working";
	}

}
