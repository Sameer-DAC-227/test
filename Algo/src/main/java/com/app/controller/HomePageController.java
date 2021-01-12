package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
@Validated
@Controller
public class HomePageController {

	public HomePageController() {
		System.out.println("In default constructor " + this.getClass().getName());
	}
	
	@GetMapping("/")
	public String getIndexPage() {
		return "/index";
	}
}