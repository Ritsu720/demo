package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "atm")
public class Atm {

	@Id
	@Column(name = "account")
	String account;
	
	@Column(name = "password")
	String pwd;
	
	@Column(name = "balance")
	int balance;

	
	/* constructor */
	public Atm() {
		super();
	}
	
	// 新增帳戶時的資料型態
	public Atm(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}

	public Atm(String account, String password, int balance) {
		super();
		this.account = account;
		this.pwd = password;
		this.balance = balance;
	}

	
	
	/* getter&setter */
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
