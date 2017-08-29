package com.revature.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.application.model.Manager;

@Controller 
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
    
    @RequestMapping("/api/sidenav")
    public ResponseEntity<Object> displaySideNav(HttpServletRequest req) {
    	Manager manager = (Manager) req.getSession().getAttribute("manager");
    	if (manager != null)
    		return ResponseEntity.ok(manager);
    	return ResponseEntity.ok(null);
    }
}
