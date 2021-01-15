package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.model.Customer;
import com.revature.util.HibernateUtil;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public boolean insertNewCustomer(Customer c) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		try {
			ses.save(c);
			t.commit();
			return true;
		}catch(Exception e){
			t.rollback();
			return false;
		}
		
	}

	@Override
	public Customer getCustomerById(int id) {
		Session ses = HibernateUtil.getSession();
		Customer c = ses.get(Customer.class, id);
		
		return c;
	}
	
	/**
	 * I wrote up examples using either HQL or Criteria API
	 */
	
	@Override
	public Customer getCustomerByCredentials(String username, String password) {
		Session ses = HibernateUtil.getSession();
//		Customer c = ses.createQuery("from Customer where username = '" + username 
//										+ "' and password = '" + password + "'", Customer.class)
//										.uniqueResult();
		Customer c = (Customer) ses.createCriteria(Customer.class)
					.add(Restrictions.eq("username", username))
					.add(Restrictions.eq("password", password)).uniqueResult();
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session ses = HibernateUtil.getSession();
		List<Customer> cList = ses.createQuery("from Customer", Customer.class).list();
		
		return cList;
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
