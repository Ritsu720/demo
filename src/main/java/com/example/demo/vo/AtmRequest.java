package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtmRequest {

	
	private String account; 
	
	@JsonProperty("password") // 資料庫名字和設定參數的名字不同時加上此行
	private String pwd;

	
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
	
	
	
	
	
	
}
