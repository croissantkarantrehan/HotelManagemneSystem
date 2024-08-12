package com.example.demo.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="roomType")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class RoomType {
	@Id
	@GeneratedValue(generator = "room_type_seq")
	@SequenceGenerator(name = "room_type_seq",sequenceName="ROOM_TYPE_SEQ", allocationSize=1)
	private long id;
	private String type;
	private int pricePerNight;
	private String description;
	private int capacity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public RoomType(long id, String type, int pricePerNight, String description, int capacity) {
		super();
		this.id = id;
		this.type = type;
		this.pricePerNight = pricePerNight;
		this.description = description;
		this.capacity = capacity;
	}
	public RoomType() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(capacity, description, id, pricePerNight, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomType other = (RoomType) obj;
		return capacity == other.capacity && Objects.equals(description, other.description) && id == other.id
				&& pricePerNight == other.pricePerNight && Objects.equals(type, other.type);
	}
	
}
