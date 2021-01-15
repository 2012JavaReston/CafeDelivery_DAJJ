package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String endpoint = req.getRequestURI();
		
		System.out.println(endpoint);
		
		switch(endpoint) {
			case "/CafeDelivery/api/signup":				
				switch(req.getMethod()) {
					case "GET":
						req.getRequestDispatcher("/signup.html").forward(req, resp);;
						break;
					case "POST":
						SignUpController.signUp(req, resp);
						break;
					default:
						resp.setStatus(405);
				}
				break;
			case "/CafeDelivery/api/login":				
				switch(req.getMethod()) {
					case "GET":
						LoginController.checkSession(req, resp);
						break;
					case "POST":
						LoginController.login(req, resp);
						break;
					default:
						resp.setStatus(405);
				}
				break;
			case "/CafeDelivery/api/order":
				switch(req.getMethod()) {
					case "GET":
						CustomerController.checkSession(req, resp);
						break;
					case "POST":
						CustomerController.checkSession(req, resp);
						break;
					default:
						resp.setStatus(405);
				}
				break;
			case "/CafeDelivery/api/order/menu":
				switch(req.getMethod()) {
					case "GET":
						CustomerController.checkSession(req, resp);
						break;
					default:
						resp.setStatus(405);
				}
				break;
			case "/CafeDelivery/api/order/history":
				switch(req.getMethod()) {
					case "GET":
						CustomerController.checkSession(req, resp);
						break;
					default:
						resp.setStatus(405);
				}
				break;
			case "/CafeDelivery/api/logout":
				switch(req.getMethod()) {
					case "POST":
						LoginController.logout(req, resp);
						break;
					default:
						resp.setStatus(405);
				}
				break;
			default:
				resp.setStatus(404);
				resp.sendRedirect("/CafeDelivery/api/login");
		}
	}
}