package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "order_table")
public class Order {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "total_price", nullable = false)
	private double totalPrice;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_fk")
	private Customer customer;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Food> foodOrdered;
	
	public Order(int id, Customer customer, List<Food> foods) {
		super();
		this.id = id;
		this.customer = customer;
		this.foodOrdered = foods;
		
		for(Food f: foods) {
			this.totalPrice += f.getPrice();
		}
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Food> getFoodOrdered() {
		return foodOrdered;
	}
	public void setFoodOrdered(List<Food> foodOrdered) {
		this.foodOrdered = foodOrdered;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", totalPrice=" + totalPrice + ", customer=" + customer + ", foodOrdered="
				+ foodOrdered + "]";
	}

}
