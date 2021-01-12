package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column(length = 20)
	String airline;
	@Column(length = 20, name = "dep_city")
	String depCity;
	@Column(length = 20, name = "arr_city")
	String arrCity;
	@Column(name = "flight_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate flightDate;
	@Column(name = "flight_time")
	LocalTime flightTime;
	@OneToMany(mappedBy = "flightId", cascade = CascadeType.ALL)
	List<Booking> bookings = new ArrayList<Booking>();
	
	public Flight() {
		System.out.println("In default constructor : " + getClass().getName());
	}

	public Flight(String airline, String depCity, String arrCity, LocalDate flightDate, LocalTime flightTime) {
		super();
		this.airline = airline;
		this.depCity = depCity;
		this.arrCity = arrCity;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public void addBooking(Booking b) {
		this.bookings.add(b);
		b.setFlightId(this);
	}
	
}
