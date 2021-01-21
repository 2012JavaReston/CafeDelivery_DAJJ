package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CustomerDaoImp;
import com.revature.dao.FoodDaoImp;
import com.revature.dao.OrderDaoImp;
import com.revature.model.Customer;
import com.revature.model.Food;
import com.revature.model.Order;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		Customer c1 = new Customer(0, "username1", "pass", "first", "last");
//		Customer c2 = new Customer(0, "username2", "pass", "second", "last");
//		Customer c3 = new Customer(0, "username3", "pass", "third", "last");
//		Customer c4 = new Customer(0, "username4", "pass", "fourth", "last");
//		
//		Food f1 = new Food(0, "Soda", 1.49);
//		Food f2 = new Food(0, "Pizza", 10.99);
//		Food f3 = new Food(0, "Burger", 6.99);
//		Food f4 = new Food(0, "Milk", 1.99);
//		Food f5 = new Food(0, "Coffee", 1.75);
//		
//		List<Food> foodList1 = new ArrayList<>();
//		List<Food> foodList2 = new ArrayList<>();
//		List<Food> foodList3 = new ArrayList<>();
//		List<Food> foodList4 = new ArrayList<>();
//		
//		foodList1.add(f1);
//		foodList1.add(f4);
//		foodList1.add(f5);
//		
//		foodList2.add(f1);
//		foodList2.add(f2);
//		
//		foodList3.add(f1);
//		foodList3.add(f1);
//		foodList3.add(f3);
//		foodList3.add(f4);
//		
//		foodList4.add(f4);
//		
//		Order o1 = new Order(0, c1, foodList1);
//		Order o2 = new Order(0, c2, foodList2);
//		Order o3 = new Order(0, c3, foodList3);
//		Order o4 = new Order(0, c4, foodList4);
//		Order o5 = new Order(0, c4, foodList4);
//		
//		FoodDaoImp fDao = new FoodDaoImp();
//		CustomerDaoImp cDao = new CustomerDaoImp();
//		OrderDaoImp oDao = new OrderDaoImp();
//		
//		cDao.insertNewCustomer(c1);
//		cDao.insertNewCustomer(c2);
//		cDao.insertNewCustomer(c3);
//		cDao.insertNewCustomer(c4);
//		cDao.insertNewCustomer(c4);
//		
//		cDao.insertNewCustomer(new Customer(0, "username1", "p", "f", "l"));
//		cDao.insertNewCustomer(new Customer(0, "username5", "p", "f", "l"));
//		
//		
//		fDao.insertNewFood(f1);
//		fDao.insertNewFood(f2);
//		fDao.insertNewFood(f3);
//		fDao.insertNewFood(f4);
//		fDao.insertNewFood(f5);
//		
//		oDao.insertNewOrder(o1);
//		oDao.insertNewOrder(o2);
//		oDao.insertNewOrder(o3);
//		oDao.insertNewOrder(o4);
//		oDao.insertNewOrder(o5);
		
//		System.out.println(cDao.getAllCustomers());
//		System.out.println(cDao.getCustomerById(1));
//		System.out.println(cDao.getCustomerByCredentials("username3", "pass"));
		
//		System.out.println(fDao.getAllFood());
//		System.out.println(fDao.getFoodById(4));
//		
//		System.out.println(oDao.getOrderById(3));
//		System.out.println(oDao.getOrdersByCustomerId(4));
		
	}

}
