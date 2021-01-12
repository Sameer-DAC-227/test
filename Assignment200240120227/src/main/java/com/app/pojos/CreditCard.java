package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "credit_card")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private long number;
	
	@Column(name = "exp_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expDate;
	
	private int cvv;
	
	@OneToOne(mappedBy = "card", cascade = CascadeType.ALL)
	private Booking bookingId;
	
	public CreditCard() {
		System.out.println("In default constructor " + getClass().getName());
	}

	public CreditCard(Integer id, long number, LocalDate expDate, int cvv, Booking bookingId) {
		super();
		this.id = id;
		this.number = number;
		this.expDate = expDate;
		this.cvv = cvv;
		this.bookingId = bookingId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Booking getBookingId() {
		return bookingId;
	}

	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}
	
	
	
}
