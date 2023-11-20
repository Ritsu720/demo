package com.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class LoopTest {

	@Test
	public void forLoop() {
		System.out.println("for Loop Test");
		for (int i = 0; i < 3; i ++) {
			System.out.println(i);
		}
		
		/* 九九乘法表 */
		for (int x = 1; x <= 9; x++) {
			for (int y = 1; y <= 9; y++) {
				/*
				if (y == 2) {
					continue; // y為2的時後不印出
				}
				*/
				
				/*
				if (y == 2) {
					break; // y為2的時候跳出y的迴圈（只會印出「（x=1~9）*（y=1）」）
				}
				*/
				
				System.out.printf("%dx%d = %d  ", x, y, x*y);
			}
			System.out.println(); // 同一個x結束後換行
		}
	}
	
	
	/* 隨機數字產生 */
	@Test
	public void randomNum() {
		/* Math.random的公式：(random值) * ( 區間上限值 - 區間下限值 + 1) + 區間下限值 */
		// 1~99（單純只打「Math.random」會含小數）
		double random99 = (int)(Math.random()*( 99 - 1 + 1) + 1);
		System.out.println(random99);
		// 20~50
		double random50 = (int)(Math.random()*( 50 - 20 + 1 ) + 20);
		System.out.println(random50);
		
		/* Random類別的公式：*/
		Random ran = new Random(); // 第一次使用會出現紅蚯蚓，鼠標移到右邊的Random，點選「import」
		// .nextInt()內的數值即為亂數的區間上限值
		// 1~99（不含小數，但只能從1開始）
		int a = ran.nextInt(99) + 1; // 亂數產生出「0~98（大於0，小於99）」的數值，因此要再+1補回數值
		System.out.println(a);
		
	}
	
	/* 練習：猜數字 */
	@Test
	public void guessNum() {
		System.out.println("Guess a number between 1~99");
		Random ran = new Random();
		int answer = ran.nextInt(99) + 1;
		System.out.println("the answer is: " + answer);
		
		int min = 1;
		int max = 99;
		
		while (true) { // 同等於「for( ; ; ){}」
			Scanner scan = new Scanner(System.in);
			int inputInt = scan.nextInt();
			
			if(inputInt < min || inputInt > max) {
				System.out.printf("Out of the range. ");
			}
			if (inputInt == answer) {
				System.out.println("Correct!");
				break;
			}
			if (inputInt < answer) {
				min = inputInt;
			} else if (inputInt > answer) {
				max = inputInt;
			}
			System.out.printf("Guess agin between %d and %d.", min, max);
		}
		
		
	}
	
}
