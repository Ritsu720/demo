package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 資料庫與屬性之間的連結
@Table(name = "menu") // import(javax.persistence)
public class Menu {

	@Id // import(javax.persistence)
	@Column(name = "name") // import(javax.persistence)
	private String name;
	
	@Column(name = "price")
	private int price;
	
	
	/* constructor */
	public Menu() {
		super();
	}

	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	
	/* getters & setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	
}
