package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Order;
import com.revature.util.HibernateUtil;

public class OrderDaoImp implements OrderDao {

	@Override
	public void insertNewOrder(Order o) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		
		ses.save(o);
		
		t.commit();
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByCustomerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Order o) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		
		ses.update(o);
		
		t.commit();
		
	}

	@Override
	public void deleteOrder(Order o) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		
		ses.delete(o);
		
		t.commit();
		
	}

}
