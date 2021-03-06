package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerDao {
	
	//Create methods
	public boolean insertNewCustomer(Customer c);
	
	
	//Read methods
	public Customer getCustomerById(int id);
	public Customer getCustomerByCredentials(String username, String password);
	public List<Customer> getAllCustomers();
	
	//Update methods
	public void updateCustomer(Customer c);
	
	
	//Delete methods
	public void deleteCustomer(Customer c);
}
