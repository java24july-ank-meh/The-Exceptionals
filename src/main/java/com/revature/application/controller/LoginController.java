package com.revature.application.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.mockmodels.User;

@Controller
public class LoginController {
	@RequestMapping(value = "api/login/{data}", method = RequestMethod.GET)
	public ResponseEntity<Object> login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//slack code to get token
		String code = req.getParameter("code");
		String clientId = "229600595489.230193848804";
		String clientSecret = "c779a43e2f51027a9865f3631db02696";
		// get parameters client_id, client_secret,code to retrieve token
		String redirectUrl = "https://slack.com/api/oauth.access?client_id=" + clientId + "&client_secret="
				+ clientSecret + "&code=" + code;

		// https://slack.com/api/oauth.access
		URL url = new URL(redirectUrl);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("POST");

		BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
		JsonObject jobj = new Gson().fromJson(br.readLine(), JsonObject.class);
		
		String userId = jobj.get("user").getAsJsonObject().get("id").getAsString();
		System.out.println(userId);
		/*System.out.println(br.readLine());
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}*/
		br.close();
		//line = sb.toString();
		 HttpSession session = req.getSession(true);
		 //System.out.println(line.user);
        session.setAttribute("id", userId);
        User user = new User("Person", "One", "1@gmail.com");
        
		return ResponseEntity.ok(user);
        
	}
}