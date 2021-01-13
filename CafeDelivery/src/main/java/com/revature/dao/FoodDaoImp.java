package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Food;
import com.revature.util.HibernateUtil;

public class FoodDaoImp implements FoodDao {

	@Override
	public void insertNewFood(Food f) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		ses.save(f);
		t.commit();
	}

	@Override
	public Food getFoodById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFood(Food f) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		
		ses.update(f);
		
		t.commit();
	}

	@Override
	public void deleteFood(Food f) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		
		ses.delete(f);
		
		t.commit();
	}

}
