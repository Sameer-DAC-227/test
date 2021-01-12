package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Flight;
import com.app.service.IFlightService;


@Controller
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private IFlightService service;
	
	public FlightController() {
		System.out.println("In default constructor : " + getClass().getName());
	}
	
	@GetMapping("/search")
	public String showSearchForm() {
		return "/flight/search";
	}
	
	@PostMapping("/search")
	public String showSearchResults(@RequestParam String depCity, @RequestParam String arrivCity, @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate flightDate, RedirectAttributes flashMap) {
		List<Flight> flights = service.getSelectedFlights(depCity, arrivCity, flightDate);
		if(flights.isEmpty()) {
			String message = "No matching flights found for requested search parameters";
			flashMap.addFlashAttribute("message", message);
			return "redirect:/flight/search";
		}
		flashMap.addFlashAttribute("flights", flights);
		return "redirect:/flight/list";
	}
	
	@GetMapping("/list")
	public String showFlights() {
		return "/flight/list";
	}
	
}
