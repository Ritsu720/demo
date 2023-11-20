package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//import org.assertj.core.util.Arrays; // 因寫在「Test」，自動import的途徑是錯的，需手動修改成「java.util」的途徑如上
import org.junit.jupiter.api.Test;

public class ArrayTest {
	
	/* Array */
	@Test
	public void arrayTest() {
		
		/* 以長度宣告Array */
		int [] arr = new int [5]; // []內的數字即為陣列的長度
		System.out.println(arr.length); // Array的長度用「.length」查看
		
		arr[0] = 1;
		arr[1] = 2;
		System.out.println(arr); // 只有變數的話，會顯示出儲存的位置
		System.out.println(Arrays.toString(arr)); // 使用「Arrays.toString()」將陣列轉成字串後印出
		
        /* 以內容宣告Array */
		int[] arr1 = {1, 3, 5, 7, 9};
		System.out.println(arr1[4]);
		
		/* 二維陣列 */
		/* 直接宣告 */
		int[][] matrix = {
				{1, 2, 3},
				{0, 9, 8}
		};
		/* 只給予空間 */
		int[][] arr23 = new int [2][3]; // 前為橫排數量，後為直列
	}

	
	/* List */
	@Test
	public void listTest() {
		
		/* 宣告List */
		List <String> strList = new ArrayList<>(); // 產生的是動態空間（見第66~68行）
		
		strList.add("A");
		strList.add("B");
		strList.add("C");
		System.out.println(strList); // List為有序，依照「.add」的先後排序
		System.out.println("strList的長度是 " + strList.size()); // List的長度要用「.size」查看
		
		/* 用for loop印出每一項 */
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i)); // 「.get」是取出陣列內容的方法，()內為索引值
		}
		
		/* 宣告固定空間List */
		List <String> strList1 = List.of("A", "S", "D", "F"); // 「List.of」的空間無法更改
		List <String> strList2 = Arrays.asList("A1", "S1", "D1", "F1"); // 「Arrays.asList」是固定的空間
		// 下一行會報錯，因為「List.of」的空間無法增加
//		strList1.add("E");
		// 下一行會報錯，因為「Arrays.asList」的空間無法增加
//		strList2.add("E1");
		
		/* 宣告動態List */
		List <String> strList3 = new ArrayList<>(List.of("B", "R", "I"));
		List <String> strList4 = new ArrayList<>(Arrays.asList("B1", "R1", "I1"));
		
	}
	
	
	/* for each */
	@Test
	public void foreachTest() {

		List <String> strList = new ArrayList<>(List.of("B", "R", "I"));
		
		/* 利用for each遍歷出每一項 */
		for(String item : strList) {
			System.out.println(item);
		}
		/* 使用預設方法的for each遍歷 */
		strList.forEach( item -> {
			System.out.println(item);
		});
	}
	
	
	/* 練習：找出小於20的質數 */
	@Test
	public void primeNum() {
		
		// 題目
		System.out.println("Enter a number to check the prime number:");
		// 設定輸入值
		Scanner scan = new Scanner(System.in);
		int target = scan.nextInt();
		
		// 設定一個List放置所有是質數的數字
		List <Integer> primeList = new ArrayList<>();
		
		// 利用for loop檢查該數字內的所有數字是否為質數
		// i是被除數
		for(int i = 2; i <= target; i++) { 
			// 預設為質數（即isPrime為true）
			boolean isPrime = true;
			// 用for loop確認是否為質數
			// j是除數
			for(int j = 2; j <= Math.sqrt(i); j++) { // 「Math.sqrt()」為開根號
				if( i % j == 0) { 
					// 如果不是質數，則將isPrime轉成false並跳出loop
					isPrime = false;
					break;
				}
			};
			// 偵測for loop中isPrime是否為true（即此i是否為質數）
			if(isPrime) {
				// 如果isPrime為true（即此i為質數），加入到primeList內
				primeList.add(i);
			}
		};
		
		System.out.println(primeList);
	}
	
}
