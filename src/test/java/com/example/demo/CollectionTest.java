package com.example.demo;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Generic;


public class CollectionTest {
	
	
	/* 使用generic（泛型）使物件可以使用多類型*/
	@Test
	public void genericTest() {
		
		Generic generic = new Generic();
		// 使用String
		generic.setAction("run");
		System.out.println(generic.getAction());
		// 使用int
		generic.setAction(123);
		System.out.println(generic.getAction());
		
	}
	
	/* List：無key-value */
	@Test
	public void listTest() {
		// 
	}
	
	
	/* Map：有key-value */
	@Test
	public void mapTest() {
		
		Map<Integer, String> map = new HashMap();
		map.put(1, "A");
		map.put(1, "AA"); // Map如果有相同的key，value會後蓋前
		map.put(2, "B");
		
		// 利用for-each印出項目
		for(Entry<Integer, String> item : map.entrySet()) { // 不確定for-each的型態的話，可以直接先寫變數的名稱，鼠標移上去讓它自動生成即可
			System.out.println("key: " + item.getKey() + " value: " + item.getValue());
		}
		
		Map<Integer, List<String>> mapp = new HashMap();
		
		
	}
}
