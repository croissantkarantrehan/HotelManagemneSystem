package com.example.demo.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Book;

public interface BookingRepo extends JpaRepository<Book, Long> {

	@Query(value="select * from  book b",nativeQuery =true )
	List<Book> find();
	
	@Query(value="select r.id  from room_type rt \r\n"
			+ "inner join room r ON r.room_type_id =rt.id \r\n"
			+ "inner join book b on b.room_id =r.id \r\n"
			+ "where ((b.check_in_time< :startdate and b.check_out_time  >:startdate) or (b.check_in_time< :enddate and b.check_out_time  >:enddate))\r\n"
			+ "or (:startdate <b.check_in_time and :enddate>b.check_out_time )",nativeQuery =true )
	List<Integer> findAllBookedRoom(Timestamp startdate,Timestamp enddate);

}
