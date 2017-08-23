package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/home")
public class HomepageController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome() {
		return "/pages/home.html";
	}
}
