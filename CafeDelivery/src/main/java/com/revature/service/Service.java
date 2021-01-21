package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.*;
import com.revature.model.*;

@Component("Service")
public class Service {
	@Autowired
	private CustomerDao cDao;
	@Autowired
	private OrderDao oDao;
	@Autowired
	private FoodDao fDao;
	
	public Service(CustomerDaoImp cDao, OrderDaoImp oDao, FoodDaoImp fDao) {
		this.cDao = cDao;
		this.oDao = oDao;
		this.fDao = fDao;
	}
	
	public boolean checkUsername(String username) {
		List<Customer> custList = cDao.getAllCustomers();
		for(Customer c: custList) {
			if(c.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean createCustomer(Customer cust) {
		return cDao.insertNewCustomer(cust);
	}
	
	public Customer checkLogin(String username, String password) {
		return cDao.getCustomerByCredentials(username, password);
	}
	
	public List<Food> checkAllFood() {
		return fDao.getAllFood();
	}

	public boolean createOrder(Order order) {
		return oDao.insertNewOrder(order);
	}

	public List<Order> checkOrdersByCustomer(int id) {
		return oDao.getOrdersByCustomerId(id);
	}
	
}
