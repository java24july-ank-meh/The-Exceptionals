package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value="/home")
public class HomepageController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ResponseEntity<Object> goHome() {
		List<String> names = new ArrayList<>();
		names.add("george");
		names.add("Hamilton");
		return ResponseEntity.ok(names);
	}
}
