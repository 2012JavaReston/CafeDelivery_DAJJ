package com.revature.dao;

import java.util.List;

import com.revature.model.Order;

public interface OrderDao {
	
	//Create methods
	public boolean insertNewOrder(Order o);
	
	//Read methods
	public Order getOrderById(int id);
	public List<Order> getOrdersByCustomerId(int id);
	
	//Update methods
	public void updateOrder(Order o);
	
	//Delete methods
	public void deleteOrder(Order o);
}
