package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

public class Car implements RunService {

	/* implemented methods from Interface */
	@Override
	public void run() {
		System.out.println("Cars are running.");
		
	}

}
