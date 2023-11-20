package com.example.demo.entity;

public class Animal {

	/* parent class */
	/* 設定變數 */
	private String name = "Animal";

	
	/* getter & setter*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	/* 預設建構方法 */
	public Animal() {
		super(); // 必須要在第一行
		System.out.println("Animal建構方法");
	}
	
	
	/* methods */
	public void eat() {
		System.out.println( this.name + " is eating.");
	}
	
	public void sleep() {
		System.out.println( this.name + " is sleeping.");
	}
	
}
