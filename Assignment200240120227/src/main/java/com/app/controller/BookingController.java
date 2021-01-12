package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Booking;
import com.app.pojos.CreditCard;
import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.service.IBookingService;
import com.app.service.IFlightService;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private IFlightService fltService;
	
	@Autowired
	private IBookingService bkService;

	@GetMapping("/book")
	public String bookFlight(@RequestParam int fid, HttpSession session) {
		Flight flight = fltService.getFlightDetails(fid);
		session.setAttribute("flight", flight);
		return ("redirect:/booking/addpassenger");
	}
	
	@GetMapping("/addpassenger")
	public String showPassengerForm(ModelMap map) {
		Passenger p = new Passenger();
		map.addAttribute("passenger", p);
		return ("/book/addpassenger");
	}
	
	@PostMapping("/addpassenger")
	public String savePassenger(@ModelAttribute (name = "passenger") Passenger p, RedirectAttributes flashMap, HttpSession session) {
		Booking booking = new Booking();
		booking.addPassenger(p);
		session.setAttribute("booking", booking);
		return ("redirect:/booking/pay");
	}
	
	@GetMapping("/pay")
	public String addCardForm(ModelMap map) {
		CreditCard card = new CreditCard();
		map.addAttribute("card",card);
		return ("/book/pay");
	}
	
	@PostMapping("/pay")
	public String processPayment(@ModelAttribute (name = "card") CreditCard c, RedirectAttributes flashMap, HttpSession session) {
		Booking booking = (Booking)session.getAttribute("booking");
		Flight flight = (Flight)session.getAttribute("flight");
		booking.addCreditCard(c);
		booking.addFlight(flight);
		booking = bkService.bookFlight(booking);
		flashMap.addFlashAttribute("booking",booking);
		session.invalidate();
		return ("redirect:/booking/success");
	}
	
	@GetMapping("/success")
	public String showCompletionPage() {
		return ("/book/success");
	}
	
}
