package com.revature.application.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.JsonObject;


@Controller
public class LogoutController extends HttpServlet {
@GetMapping("api/logout1")

    protected ResponseEntity<Object> endsession (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
//        response.sendRedirect(request.getContextPath() + "/login.html");
        System.out.println("try again");
        JsonObject jobj = new JsonObject();
        jobj.addProperty("name", "Unknown User");
        return ResponseEntity.ok(jobj.toString());
    }

}
