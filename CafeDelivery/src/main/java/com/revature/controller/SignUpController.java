package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Customer;
import com.revature.service.Service;

public class SignUpController {
	
	private static Service service = new Service();

	public static void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		Customer cust = om.readValue(req.getReader(), com.revature.model.Customer.class);
		
		boolean usernameAvailable = service.checkUsername(cust.getUsername());
		if(usernameAvailable) {
			if(service.createCustomer(cust)) {
				resp.setStatus(200);
				resp.sendRedirect("/CafeDelivery/api/login");
			} else {
				resp.setStatus(500);
			}
		} else {
			resp.setStatus(406);
			resp.getWriter().write("Username taken");
		}
	}
	
}
