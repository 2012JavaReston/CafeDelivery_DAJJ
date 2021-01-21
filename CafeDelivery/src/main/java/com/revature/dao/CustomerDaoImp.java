package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Customer;

@Repository("CustomerDao")
@Transactional
public class CustomerDaoImp implements CustomerDao {

	private SessionFactory sesFact;

	public CustomerDaoImp(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	@Override
	public boolean insertNewCustomer(Customer c) {
		try {
			this.sesFact.getCurrentSession().save(c);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Customer getCustomerById(int id) {
		return this.sesFact.getCurrentSession().get(Customer.class, id);
	}
	
	/**
	 * I wrote up examples using either HQL or Criteria API
	 */
	
	@Override
	public Customer getCustomerByCredentials(String username, String password) {
		return this.sesFact.getCurrentSession().createQuery("from Customer where username = '" + username 
			+ "' and password = '" + password + "'", Customer.class)
			.uniqueResult();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.sesFact.getCurrentSession().createQuery("from Customer", Customer.class).list();
	}
	
	@Override
	public void updateCustomer(Customer c) {
		this.sesFact.getCurrentSession().update(c);
	}

	@Override
	public void deleteCustomer(Customer c) {
		this.sesFact.getCurrentSession().delete(c);
	}
	
}
