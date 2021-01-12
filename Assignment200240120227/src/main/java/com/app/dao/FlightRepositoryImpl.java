package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Flight;

@Repository
public class FlightRepositoryImpl implements IFlightRepository {
	
	@Autowired
	private EntityManager mgr;
	
	public FlightRepositoryImpl() {
		System.out.println("In default constructor : " + getClass().getName());
	}

	@Override
	public List<Flight> getSelectedFlights(String depCity, String arrivCity, LocalDate flightDate) {
		String jpql = "select f from Flight f where f.depCity=:dep and f.arrCity=:arr and f.flightDate=:dt";
		return mgr.createQuery(jpql, Flight.class).setParameter("dep",depCity).setParameter("arr",arrivCity).setParameter("dt", flightDate).getResultList();
	}

	@Override
	public Flight getFlightDetails(int flightId) {
		String jpql = "select f from Flight f left join fetch f.bookings where f.id=:flightId";
		return mgr.createQuery(jpql, Flight.class).setParameter("flightId",flightId).getSingleResult();
	}

}
