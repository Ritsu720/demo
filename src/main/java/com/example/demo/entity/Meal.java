package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "meal")
@IdClass(value = MealId.class) // 連結到Entity MealId
public class Meal {
	
	
	@Id
	@Column(name = "name")
	String name;
	
	@Id
	@Column(name = "cooking_style")
	String cookingStyle;
	
	@Column(name = "price")
	int price;
	
	
	/* constructor */
	public Meal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meal(String name, String cookingStyle, int price) {
		super();
		this.name = name;
		this.cookingStyle = cookingStyle;
		this.price = price;
	}

	
	/* getter&setter*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCookingStyle() {
		return cookingStyle;
	}

	public void setCookingStyle(String cookingStyle) {
		this.cookingStyle = cookingStyle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
