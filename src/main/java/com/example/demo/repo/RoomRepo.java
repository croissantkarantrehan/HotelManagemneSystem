package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Room;
import com.example.demo.entity.dto.roomDto;

public interface RoomRepo extends JpaRepository<Room, Long>{

	@Query(value="select r.id as RoomId ,rt.\"type\" as RoomType from room r \r\n"
			+ "inner join room_type rt on rt.id =r.room_type_id \r\n"
			+ "where r.id not in :listOfBookedRoom",nativeQuery =true)
	List<roomDto> fetchRoomNotInList(List<Integer> listOfBookedRoom);

//	List<HotelRoom> findByType(RoomType roomType);

//@Query(value="select * from room where room_type_id=:roomtype",nativeQuery =true )
//	List<HotelRoom> findAllByRoomId(Long roomtype);

	
	@Query(value="select r.id as RoomId ,rt.\"type\" as RoomType,rt.capacity as Capacity,"
			+ "rt.description as Description,rt.price_per_night as PricePerNight from room r \r\n"
			+ "inner join room_type rt on rt.id =r.room_type_id \r\n",nativeQuery =true)
	List<roomDto> fetchAllRoomRoomType();

}
