package com.example.demo.entity;

public class Generic<T> {

	
	private T action;

	
	/* constructor */
	public Generic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Generic(T action) {
		super();
		this.action = action;
	}

	
	/* getter&setter */
	public T getAction() {
		return action;
	}

	public void setAction(T action) {
		this.action = action;
	}
	
	
}
