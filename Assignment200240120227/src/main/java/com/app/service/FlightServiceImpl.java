package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IFlightRepository;
import com.app.pojos.Flight;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService {
	@Autowired
	private IFlightRepository repo;
	
	public FlightServiceImpl() {
		System.out.println("In default constructor : " + getClass().getName());
	}
	
	@Override
	public List<Flight> getSelectedFlights(String depCity, String arrivCity, LocalDate flightDate) {
		return repo.getSelectedFlights(depCity, arrivCity, flightDate);
	}

	@Override
	public Flight getFlightDetails(int flightId) {
		return repo.getFlightDetails(flightId);
	}

}
