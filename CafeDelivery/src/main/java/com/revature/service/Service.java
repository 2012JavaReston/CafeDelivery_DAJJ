package com.revature.service;

import java.util.List;

import com.revature.dao.*;
import com.revature.model.*;

public class Service {

	private CustomerDao cDao;
	private OrderDao oDao;
	private FoodDao fDao;
	
	public Service() {
		this.cDao = new CustomerDaoImp();
		this.oDao = new OrderDaoImp();
		this.fDao = new FoodDaoImp();
	}
	
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
