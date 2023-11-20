package com.example.demo.entity;

public class Bird extends Animal{

	/* child class*/
	/* 預設建構方法 */
	public Bird() {
		super();
		System.out.println("Bird建構方法");
	}
	
	/* methods */
	@Override // 覆寫原父層資料
	public void eat() {
		System.out.println( super.getName() + " is eating IN BIRD CLASS.");
	}

	@Override
	public void sleep() {
		System.out.println( super.getName() + " is sleeping IN BIRD CLASS.");
	}
	
	public void flying() {
		System.out.println( super.getName() + " is flying IN BIRD CLASS.."); // "super"代表父類別
	}
	
}
