package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

@SuppressWarnings("serial")
public class MealId implements Serializable{ // Class名稱報錯時，選項中的三個Add都可以選

	/* Id的變數們 */
	String name;
	
	String cookingStyle;
	
	
	/* constructor（給DB用） */
	public MealId() {
		super();
	}

	public MealId(String name, String cookingStyle) {
		super();
		this.name = name;
		this.cookingStyle = cookingStyle;
	}


	/* getter&setter */
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
	
	
	

}
