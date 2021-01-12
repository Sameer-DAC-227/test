package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Flight;

public interface IFlightRepository {
	
	public List<Flight> getSelectedFlights(String depCity, String arrivCity, LocalDate flightDate);

	public Flight getFlightDetails(int flightId);
}
