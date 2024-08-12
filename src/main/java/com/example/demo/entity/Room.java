package com.example.demo.entity;


//package com.example.demo.entity;



import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="room")	
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Room {
	@Id
	@GeneratedValue(generator = "room_seq")
	@SequenceGenerator(name = "room_seq",sequenceName="ROOM_SEQ", allocationSize=1)
	private long id;
	private String occupancyStatus;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="roomTypeId")
	private RoomType type;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOccupancyStatus() {
		return occupancyStatus;
	}

	public void setOccupancyStatus(String occupancyStatus) {
		this.occupancyStatus = occupancyStatus;
	}

	

	public Room(long id, String occupancyStatus) {
		super();
		this.id = id;
		this.occupancyStatus = occupancyStatus;
	
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Room RoomDto(Room room) {
		Room obj=new Room();
		obj.id = room.getId();
		obj.occupancyStatus = room.getOccupancyStatus();
		return obj;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash( id, occupancyStatus, type);
	}

	
	
	

}
