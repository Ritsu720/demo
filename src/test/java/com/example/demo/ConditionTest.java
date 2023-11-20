package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ConditionTest {

	/* if */
	@Test // 新建立時手動輸入"@Test"會出現紅蚯蚓，鼠標移動上去後點選「import」，會自動出現import那行
	public void ifTest() {
		int a = 5;
		if (a > 5) {
			System.out.println(">5");
		} else {
			System.out.println("!");
		}

		/* 以三元的方式書寫 */
		System.out.println(a > 5 ? ">5" : "!");
	}

	/* if-else-if */
	@Test
	public void elseifTest() {
		int a = 5;
		if (a > 5) {
			System.out.println(">5");
		} else if (a > 6) {
			System.out.println(">6");
		} else {
			System.out.println("other");
		}
	}

	/* 時薪計算練習 */
	@Test
	public void practiceSalary() {
		int hourlySalary = 150;

		Scanner scan = new Scanner(System.in);
		int workHour = scan.nextInt();

		if (workHour < 40 && workHour > 0) {
			System.out.println(hourlySalary * 0.8 * workHour);
		} else if (workHour == 40) {
			System.out.println(hourlySalary * workHour);
		} else if (workHour > 40 && workHour <= 50) {
			System.out.println(hourlySalary * 1.2 * workHour);
		} else if (workHour > 50) {
			System.out.println(hourlySalary * 1.6 * workHour);
		}
	}

	/* 分數等級練習 */
	@Test
	public void practiceScore() {

		/* 一點關於double的概念 */
		double a = 95 / 10;
		double aa = 95.0 / 10;
		System.out.println(a); // 結果是9.0，因為變數a後面宣告的是整數「95」（java默認數字是int型態）
		System.out.println(aa); // 結果是9.5，因為變數aa後面宣告的是浮點數「95.0」（如果是「10.0」也可以）

		System.out.println("Please enter your score:");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();

		switch (score / 10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
	}

	/* System.in */
	@Test
	public void scan() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a sentence:");
		String strLine = scan.nextLine(); // scan.nextLine會將輸入的整行直接印出
		System.out.println("your sentence: " + strLine);

		System.out.println("\nPlease enter two words:");
		String strA = scan.next(); // 以空格區分變數的值
		String strB = scan.next();
		System.out.println("input: " + strA + strB);
	}

	/* 練習：幾天後是星期幾 */
	@Test
	public void day() {
		Scanner scan = new Scanner(System.in);
		System.out.println("今天是星期：");
		String weekday = scan.next();

		int weekdayNum = 0;

		switch (weekday) {
		case "天":
		case "日":
			weekdayNum = 0;
			break;
		case "一":
			weekdayNum = 1;
			break;
		case "二":
			weekdayNum = 2;
			break;
		case "三":
			weekdayNum = 3;
			break;
		case "四":
			weekdayNum = 4;
			break;
		case "五":
			weekdayNum = 5;
			break;
		case "六":
			weekdayNum = 6;
			break;
		}

		System.out.println("計算幾天後："); // 調整：有要使用的變數在方法的前面宣告，注意宣告和方法不要距離太遠
		int days = scan.nextInt();
		String output = "默認";

		switch ((days + weekdayNum) % 7) {
		case 0:
			System.out.println("今天是星期" + weekday + "，" + days + "天後是星期日"); // 原自己的寫法
			break;
		case 1:
			System.out.printf("今天是星期%s，%d天後是星期一", weekday, days); // 更改成：printf( "顯示的字", 參數一（此處為字串%s）, 參數二（此處為數字%d）)
			break;
		case 2:
			output = "二"; // 二更：使用參數帶入不同的星期
			break;
		case 3:
			output = "三";
			break;
		case 4:
			output = "四";
			break;
		case 5:
			output = "五";
			break;
		case 6:
			output = "六";
			break;
		}
		System.out.printf("今天是星期%s，%d天後是星期%s", weekday, days, output); // 二修：使用參數帶入不同的星期
	}

	/* 檢討：switch練習的精簡版 */
	@Test
	public void switchPractice() {
		System.out.println("星期和日子皆只能輸入數字");
		Scanner scan = new Scanner(System.in);
		System.out.println("今天是星期：");
		int InputNum = scan.nextInt();
		String weekday = switchDay(InputNum);
		
		System.out.println("計算幾天後：");
		int days = scan.nextInt();
		String output = switchDay( (InputNum + days) % 7);
		
		System.out.printf("今天是星期%s，%d天後是星期%s", weekday, days, output);
	}
	
	/* 檢討：switch練習的精簡版的方法 */
	@Test
	public String switchDay(int inputNum) { // 在方法的小括弧內直接宣告的變數可以帶入骯
		
		String weekday = "";
		
		switch (inputNum) {
			case 7:
			case 0:
				weekday = "日";
				break;
			case 1:
				weekday = "一";
				break;
			case 2:
				weekday = "二";
				break;
			case 3:
				weekday = "三";
				break;
			case 4:
				weekday = "四";
				break;
			case 5:
				weekday = "五";
				break;
			case 6:
				weekday = "六";
				break;
		}
		return weekday;
	}
}
