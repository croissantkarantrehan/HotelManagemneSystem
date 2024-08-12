package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RoomType;

public interface RoomTypeRepo extends JpaRepository<RoomType, Long> {

}
