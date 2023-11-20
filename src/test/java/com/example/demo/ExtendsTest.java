package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Bird;
import com.example.demo.entity.Car;
import com.example.demo.entity.Dog;
import com.example.demo.entity.Doggy;

public class ExtendsTest {
	
	/* extends */
	@Test
	public void extendsTest(){
		
		/* Class Animal */
		Animal animal = new Animal();
		System.out.println("The name in Class Animal is: " + animal.getName());
		animal.eat(); // 印出eating
		animal.sleep(); // 印出sleeping
		System.out.println("--------------------");
		
		/* Class Bird */
		Bird bird = new Bird();
		// 使用animal內的變數和methods
		bird.setName("Bird");
		System.out.println("The name in Class Bird is: " + bird.getName());
		bird.eat(); // method from Class Animal
		bird.sleep(); // method from Class Animal
		bird.flying(); // method from Class Bird: cannot get the name in Class Animal
		
	}
	
	
	/* is-a & has-a */
	@Test
	public void aTest() {
		
		/* is-a */
		Animal animal = new Animal();
		Bird bird = new Bird();
		Dog dog = new Dog();
		System.out.println("--------------------");
		System.out.println(bird instanceof Animal); // 此行為「true」，因為bird是Animal的child class
//		System.out.println(dog instanceof Animal); // 此行會直接報錯，因為兩者無關係
		System.out.println(animal instanceof Bird); // 此行為「false」，因為animal不是Bird的child class
		System.out.println("--------------------");
		
		/* has-a */
		/* 原本的資料庫Class Dog內預設的name */
		System.out.println(dog.getName());
		/* 使用了Class Dog資料庫的新Class Doggy */
		// 開啟Class Doggy看更多
		Doggy doggy = new Doggy();
		System.out.println( "The name from Class Dog is: " + doggy.getDog().getName()); // 直接使用Class Dog內的name
		doggy.changeName("Happy"); // 利用Class Dog內的變數設立的method
		
	}
	
	
	/* Polymorphism 多形 */
	@Test
	public void polymorphismTest() {
		
		/* 一般情況：new左右相同Class */
		Animal animal = new Animal();
		animal.eat();
		Bird bird = new Bird();
		bird.eat();
		Doggy doggy = new Doggy();
		doggy.eat();
		System.out.println("--------------------");
		
		/* 使用了extends和@Override：new左邊是parent class、右邊是child class */
		Animal animm = new Animal();
		animm.eat();
		// 左邊是parent class、右邊是new child class的話，執行的會是child class內parent class的方法
		Animal birdd = new Bird(); 
		birdd.eat(); // 左邊用parent class宣告的話，只能使用parent class的方法，不能使用child class自己建立的方法
//		Animal doggyy = new Doggy(); // 沒有繼承關係（extends）就不能這樣使用
//		doggyy.eat();
		
	}
	
	/* Interface */
	@Test
	public void interfaceTest() {
		Car car = new Car();
		car.run();
		Dog dog = new Dog();
		dog.run();
	}
}
