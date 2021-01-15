package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.*;
import com.revature.service.Service;

public class CustomerController {
	
	private static final Logger loggy = Logger.getLogger(LoginController.class);
	private static Service service = new Service();

	public static void checkSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sesh = req.getSession(false);
		if(sesh != null && sesh.getAttribute("customer") != null) {
			Customer cust = (Customer) sesh.getAttribute("customer");
			String username = cust.getUsername();
			String password = cust.getPassword();
			
			if(cust.equals(service.checkLogin(username, password))) {
				switch(req.getMethod()) {
					case "GET":
						resp.setStatus(200);
						String endpoint = req.getRequestURI();
						switch(endpoint) {
							case "/CafeDelivery/api/order":
								req.getRequestDispatcher("/customer.html").forward(req, resp);
								break;
							case "/CafeDelivery/api/order/menu":
								getMenu(req, resp);
								break;
							case "/CafeDelivery/api/order/history":
								getOrders(req, resp, cust);
								break;
						}
						break;
					case "POST":
						submitOrder(req, resp, cust);
						break;
				}
			} else {
				resp.setStatus(401);
				resp.sendRedirect("/CafeDelivery/api/login");
			}
		} else {
			resp.setStatus(401);
			resp.sendRedirect("/CafeDelivery/api/login");
		}
	}
	
	public static void getMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		
		List<Food> menu = service.checkAllFood();
		resp.getWriter().write(om.writeValueAsString(menu));
	}
	
	public static void getOrders(HttpServletRequest req, HttpServletResponse resp, Customer cust) throws ServletException, IOException {
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		
		List<Order> orderList = service.checkOrdersByCustomer(cust.getId());
		resp.getWriter().write(om.writeValueAsString(orderList));
	}
	
	public static void submitOrder(HttpServletRequest req, HttpServletResponse resp, Customer cust) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		Order order = om.readValue(req.getReader(), com.revature.model.Order.class);
		
		order.setCustomer(cust);
		
		if(service.createOrder(order)) {
			loggy.info(cust.getFirstName() + " " + cust.getLastName() + " (" + cust.getUsername() + ") submitted an order");
			
			resp.setStatus(200);
			resp.getWriter().write("Order submitted");
		} else {
			loggy.error("Failed to submit an order");
			
			resp.setStatus(500);
			resp.getWriter().write("Failed to submit order");
		}
	}
	
}
