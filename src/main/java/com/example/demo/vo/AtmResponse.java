package com.example.demo.vo;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;

public class AtmResponse {

	/* parameter */
	private Atm atm;
	
	private RtnCode rtnCode;

	
	/* constructor */
	public AtmResponse() {
		super();
	}
	
	public AtmResponse(Atm atm, RtnCode rtnCode) {
		super();
		this.atm = atm;
		this.rtnCode = rtnCode;
	}


	/* getter&setter */
	public Atm getAtm() {
		return atm;
	}
	
	public RtnCode getRtnCode() {
		return rtnCode;
	}
	
}
