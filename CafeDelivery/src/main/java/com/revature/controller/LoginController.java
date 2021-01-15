package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Customer;
import com.revature.service.Service;

public class LoginController {
	
	private static final Logger loggy = Logger.getLogger(LoginController.class);
	private static Service service = new Service();
	
	public static void checkSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sesh = req.getSession(false);
		if(sesh != null && sesh.getAttribute("customer") != null) {
			Customer cust = (Customer) sesh.getAttribute("customer");
			String username = cust.getUsername();
			String password = cust.getPassword();
			
			if(cust.equals(service.checkLogin(username, password))) {
				resp.setStatus(200);
				resp.sendRedirect("/CafeDelivery/api/order");
			} else {
				resp.setStatus(401);
			}
		} else {
			resp.setStatus(200);
			req.getRequestDispatcher("/login.html").forward(req, resp);
		}
	}
	
	public static void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		Customer cust = om.readValue(req.getReader(), com.revature.model.Customer.class);
		String username = cust.getUsername();
		String password = cust.getPassword();
		
		cust = service.checkLogin(username, password);
		if(cust != null) {
			HttpSession sesh = req.getSession();
			sesh.setAttribute("customer", cust);
			
			loggy.info(cust.getFirstName() + " " + cust.getLastName() + " (" + cust.getUsername() + ") has logged in");

			resp.setStatus(200);
			resp.sendRedirect("/CafeDelivery/api/order");
		} else {
			resp.setStatus(401);
			resp.getWriter().write("Invalid username or password");
		}
	}
	
	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		resp.setStatus(200);
		resp.sendRedirect("/CafeDelivery/api/login");
	}

}
