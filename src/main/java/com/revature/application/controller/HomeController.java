package com.revature.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.application.model.Manager;

@Controller 
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
    
    @RequestMapping("/api/sidenav")
    public ResponseEntity<Object> displaySideNav(HttpServletRequest req) {
    	String user = (String) req.getSession().getAttribute("user");
    	if (user != null)
    		return ResponseEntity.ok(user);
    	JsonObject jobj = new JsonObject();
    	jobj.addProperty("name", "Unknown User");
    	return ResponseEntity.ok(jobj.toString());
    }
}
