package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IBookingRepository;
import com.app.pojos.Booking;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository repo;
	
	@Override
	public Booking bookFlight(Booking b) {
		return repo.bookFlight(b);
	}

}
