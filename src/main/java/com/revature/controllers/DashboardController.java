package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.mockmodels.User;

@Controller
//@RequestMapping(value="/home")
public class DashboardController {
	
	//the sidenavController calls this to retrieve the data it needs
	@RequestMapping(value="/sidenav", method=RequestMethod.GET)
	public ResponseEntity<Object> sideNavInfo() {
		User u = new User("User", "Usington", "user@gmail.com");
		return ResponseEntity.ok(u);
	}
	
	@RequestMapping(value="/residents", method=RequestMethod.GET)
	public ResponseEntity<Object> displayResidents() {
		List<User> users = new ArrayList<>();
		users.add(new User("Person", "One", "1@gmail.com"));
		users.add(new User("Person", "Two", "2@gmail.com"));
		users.add(new User("Person", "Three", "3@gmail.com"));
		users.add(new User("Person", "Four", "4@gmail.com"));
		users.add(new User("Person", "Five", "5@gmail.com"));
		
		return ResponseEntity.ok(users);
	}
}
