package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Order;

@Repository("OrderDao")
@Transactional
public class OrderDaoImp implements OrderDao {

	private SessionFactory sesFact;

	public OrderDaoImp(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	@Override
	public boolean insertNewOrder(Order o) {
		try {
			this.sesFact.getCurrentSession().save(o);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public Order getOrderById(int id) {
		return this.sesFact.getCurrentSession().get(Order.class, id);
	}

	@Override
	public List<Order> getOrdersByCustomerId(int id) {
		return this.sesFact.getCurrentSession().createQuery("from Order where customer_fk = " + id , Order.class).list();
	}

	@Override
	public void updateOrder(Order o) {
		this.sesFact.getCurrentSession().update(o);
	}

	@Override
	public void deleteOrder(Order o) {
		this.sesFact.getCurrentSession().delete(o);
		
	}

}
