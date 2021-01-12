package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Booking;

@Repository
public class BookingRepositoryImpl implements IBookingRepository {

	@PersistenceContext
	private EntityManager mgr;
	
		
	@Override
	public Booking bookFlight(Booking b) {
		mgr.persist(b.getCard());
		mgr.persist(b.getPassenger());
		mgr.persist(b);
		return b;
	}

}
