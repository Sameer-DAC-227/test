package com.app.pojos;

import javax.persistence.*;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 20)
	private String email;
	
	@Column(length = 10)
	private String phone;

	@OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL)
	private Booking bookingId;
	
	public Passenger() {
		System.out.println("In default constructor " + getClass().getName());
	}

	public Passenger(Integer id, String name, String email, String phone, Booking bookingId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.bookingId = bookingId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Booking getBookingId() {
		return bookingId;
	}

	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}

	
	
}
