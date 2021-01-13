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
		Session ses = HibernateUtil.getSession();
		Order o = ses.get(Order.class, id);
		
		return o;
	}

	@Override
	public List<Order> getOrdersByCustomerId(int id) {
		Session ses = HibernateUtil.getSession();
		List<Order> orderList = ses.createQuery("from Order where customer_fk = " + id , Order.class).list();
		
		return orderList;
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
