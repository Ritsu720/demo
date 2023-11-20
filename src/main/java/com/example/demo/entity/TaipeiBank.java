package com.example.demo.entity;

public class TaipeiBank {
	
	/* Attributes */
	private String branch;
	
	private String user;
	
	private int balance;

	
	/* Getters & Setters */
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	/* method */
	/* 存款 */
	public int saving (int amount) {
		
		if(amount > 0) {  // 設置防呆（撇除不小心輸入到負數的狀況）
			this.balance += amount;
		}
		return balance;
		
	}
	/* 提款 */
	public int withdraw (int amount) {
		
		if (amount > 0 && amount <= balance) {
				this.balance -= amount;
		}
		return balance;
	}
	
}
