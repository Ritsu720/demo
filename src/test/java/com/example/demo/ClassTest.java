package com.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.demo.entity.Dog;
import com.example.demo.entity.TaipeiBank;

public class ClassTest {
	
	@Test
	public void classDogTest() {
		
		/* 使用自定義Class「Dog.java」中宣告的Class Dog */
		Dog dog = new Dog();
		
		/* 用「Class名.get變數名」取出「Dog.java」中變數的值 */
		String name = dog.getName(); 
		System.out.println(name);// sysout的結果是「null」，因為Class Dog中的name沒有設定初始值
		
		/* 用「Class名.set變數名」設定「Dog.java」中變數的值 */
		dog.setName("Lily");
		String changeName = dog.getName();
		System.out.println(changeName);
		
	}
	
	
	/* Taipei Bank 的測試使用 */
	@Test
	public void taipeiBank() {
		TaipeiBank bank = new TaipeiBank();
		
		/* show the balance */
		int balance = bank.getBalance();
		System.out.println("Your balance is " + balance);
	/*
		// Assert偵測
		// 假如balance不等於1000（左邊條件式），在JUnit內會顯示"saving error!"（右邊字串）
		Assert.isTrue(bank.getBalance() == 100, "saving error!");
	*/
		
		/* saving */
		System.out.println("Please enter the saving amount:");
		Scanner scan = new Scanner(System.in);
		int savingAmount = scan.nextInt();
		bank.saving(savingAmount);
		// 檢查新餘額
		balance = bank.getBalance();
		System.out.println(balance);
		
		/* withdraw */
		System.out.println("Please enter the withdraw amount:");
		int withdrawAmount = scan.nextInt();
		bank.withdraw(withdrawAmount);
		// 檢查新餘額
		balance = bank.getBalance();
		System.out.println(balance);
		
	}
	
	
	/* 建構方法 */
	@Test
	public void classTest() {
		
		/* static方法的呼叫 */
		/* 通常會用在「工具類」的方法 */
		Dog dog = new Dog("Lily", "white", 1);
		dog.tryNoStatic(); // 沒有static的方法必須先new才能使用變數
		Dog.tryStatic(); // 有static的方法可以直接使用
		Math.random(); // ctrl+click查看有static，可以直接使用
		Random ran = new Random(); // ctrl+click查看沒有static，需要使用"new"重新宣告
		ran.nextInt();
		
	}
	

}
