package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Food;

@Repository("FoodDao")
@Transactional
public class FoodDaoImp implements FoodDao {

	private SessionFactory sesFact;

	public FoodDaoImp(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	@Override
	public void insertNewFood(Food f) {
		this.sesFact.getCurrentSession().save(f);
	}

	@Override
	public Food getFoodById(int id) {
		return this.sesFact.getCurrentSession().get(Food.class, id);
	}

	@Override
	public List<Food> getAllFood() {
		return this.sesFact.getCurrentSession().createQuery("from Food", Food.class).list();
	}

	@Override
	public void updateFood(Food f) {
		this.sesFact.getCurrentSession().update(f);
	}

	@Override
	public void deleteFood(Food f) {
		this.sesFact.getCurrentSession().delete(f);
	}

}
