package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HotelData;

public interface HotelDataRepo extends JpaRepository<HotelData, Long> {

}
