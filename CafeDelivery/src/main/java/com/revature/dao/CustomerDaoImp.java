package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Customer;
import com.revature.util.HibernateUtil;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public void insertNewCustomer(Customer c) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		
		ses.save(c);
		
		t.commit();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateCustomer(Customer c) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		
		ses.update(c);
		
		t.commit();
		
	}

	@Override
	public void deleteCustomer(Customer c) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		
		ses.delete(c);
		
		t.commit();
		
	}
	
}
