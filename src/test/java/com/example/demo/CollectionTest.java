package com.example.demo;



import org.junit.jupiter.api.Test;

import com.example.demo.entity.Generic;


public class CollectionTest {
	
	@Test
	public void genericTest() {
		
		Generic generic = new Generic();
		generic.setAction("run");
		System.out.println(generic.getAction());
		
		generic.setAction(123);
		System.out.println(generic.getAction());
		
		
	}
}
