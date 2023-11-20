package com.example.demo.entity;

public class Doggy{
	
	/* has-a關係 */
	// 宣告Class Dpg
	private Dog dog = new Dog();
	
	
	/* 順手getter&setter*/
	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}


	// 使用Class Dog內的變數，設定名字並印出
	public void changeName(String name) {
		dog.setName(name);
		System.out.println("The name now is: " + dog.getName());
	}
	
	/* 測試polymorphism用 */
	public void eat() {
		System.out.println( " is eating IN Doggy CLASS.");
	}
	
}
