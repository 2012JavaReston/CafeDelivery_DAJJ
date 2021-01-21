//package com.revature.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.model.Customer;
//import com.revature.service.Service;
//
//public class SignUpController {
//	
//	private static final Logger loggy = Logger.getLogger(LoginController.class);
//	private static Service service = new Service();
//
//	public static void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ObjectMapper om = new ObjectMapper();
//		Customer cust = om.readValue(req.getReader(), com.revature.model.Customer.class);
//		
//		boolean usernameAvailable = service.checkUsername(cust.getUsername());
//		if(usernameAvailable) {
//			if(service.createCustomer(cust)) {
//				loggy.info(cust.getFirstName() + " " + cust.getLastName() + " (" + cust.getUsername() + ") created an account");
//				
//				resp.setStatus(200);
//				resp.sendRedirect("/CafeDelivery/api/login");
//			} else {
//				loggy.error("Failed to create an account");
//				
//				resp.setStatus(500);
//				resp.getWriter().write("Failed to create account");
//			}
//		} else {
//			resp.setStatus(406);
//			resp.getWriter().write("Username taken");
//		}
//	}
//	
//}
