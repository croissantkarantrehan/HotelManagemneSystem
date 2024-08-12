package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(generator = "PaymentSeq")
	@SequenceGenerator(name="payment_seq",sequenceName = "PaymentSeq",allocationSize = 2)
	private long id;
	private String amount;
	private Timestamp paymentDate;
	private String paymentMethod;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private Book booking;
	
	

}
