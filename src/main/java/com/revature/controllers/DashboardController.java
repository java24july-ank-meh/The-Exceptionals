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
	public ResponseEntity<Object> goHome() {
		User u = new User("George", "Hamilton", "gh@gmail.com");
		return ResponseEntity.ok(u);
	}
}
