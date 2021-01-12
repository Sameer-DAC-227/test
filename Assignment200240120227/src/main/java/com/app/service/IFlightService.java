package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Flight;

public interface IFlightService {

	public List<Flight> getSelectedFlights(String depCity, String arrivCity, LocalDate flightDate);

	public Flight getFlightDetails(int flightId);
}
