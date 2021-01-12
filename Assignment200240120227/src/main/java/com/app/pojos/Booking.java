package com.app.pojos;

import javax.persistence.*;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "passenger_id")
	private Passenger passenger;
	
	@OneToOne
	@JoinColumn(name = "card_id")
	private CreditCard card;
	
	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flight flightId;
	
	
	public Booking() {
		System.out.println("In default constructor " + getClass().getName());
	}

	

	public Booking(Integer id, Passenger passenger, CreditCard card, Flight flightId) {
		super();
		this.id = id;
		this.passenger = passenger;
		this.card = card;
		this.flightId = flightId;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Passenger getPassenger() {
		return passenger;
	}


	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}


	public CreditCard getCard() {
		return card;
	}


	public void setCard(CreditCard card) {
		this.card = card;
	}


	public Flight getFlightId() {
		return flightId;
	}


	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	}



	public void addPassenger(Passenger passsenger) {
		this.passenger = passsenger;
		passsenger.setBookingId(this);
	}
	
	public void addCreditCard(CreditCard card) {
		this.card = card;
		card.setBookingId(this);
	}
	
	public void addFlight(Flight f) {
		this.flightId = f;
		f.bookings.add(this);
	}
	

}
