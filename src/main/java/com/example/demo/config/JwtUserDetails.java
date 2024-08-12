package com.example.demo.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repo.UserDetailsRepo;
import com.example.demo.entity.UserTable;

@Service
public class JwtUserDetails implements UserDetailsService {

	
	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserTable user= userDetailsRepo.findByName(username);
		return new User(user.getName(), user.getPassword(), new ArrayList<>());
	
	}

}
