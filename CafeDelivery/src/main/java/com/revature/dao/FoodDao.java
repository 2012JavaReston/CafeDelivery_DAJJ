package com.revature.dao;

import java.util.List;

import com.revature.model.Food;

public interface FoodDao {
	
	//Create methods
	public void insertNewFood(Food f);
	
	//Read methods
	public Food getFoodById(int id);
	public List<Food> getAllFood();
	
	//Update methods
	public void updateFood(Food f);
	
	//Delete methods
	public void deleteFood(Food f);
}
