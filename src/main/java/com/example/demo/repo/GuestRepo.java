package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HotelGuest;

public interface GuestRepo extends JpaRepository<HotelGuest, Long> {

}
