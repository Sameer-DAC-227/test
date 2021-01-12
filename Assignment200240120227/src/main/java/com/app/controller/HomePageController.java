package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	public HomePageController() {
		System.out.println("In default constructor : " + getClass().getName());
	}

	@RequestMapping("/")
	public String getIndexPage() {
		System.out.println("In / mapping method");
		return("/index");
	}
}
