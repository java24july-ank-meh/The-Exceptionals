package com.revature.application.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.application.model.ApartmentComplex;
import com.revature.application.service.ManagerService;

/*@Controller
@RequestMapping(value="/manager")*/
@RestController
@RequestMapping("api")
public class ManagerController {

	@Autowired
	ManagerService service;	
	
	
}
