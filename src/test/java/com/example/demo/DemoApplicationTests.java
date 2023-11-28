package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest; // 註解掉此行以避免用sysout的時候跑出一串跟main有關的數據

//@SpringBootTest // 此行也註解掉，避免error產生
public class DemoApplicationTests { // 「public」是最大的「權限」

	@Test
	public void firstTest() { // 「void」是「回傳的型態」；「firstText」是「方法的名稱」依據需求自訂即可
		
		/* 數字型態 */
		byte a = 127; // 8位元數字，範圍是-128~127
		short b = 32767; // 16位元數字，範圍是-32768~32767
		int c = 2147483647; // 32位元數字，最常使用
		long d = 9223372036854775807L; // 64位元數字，後面要加上"L"

		/* 關於sysout */
		/* System.out.println()：會自動換行 */
		System.out.println(a);

		/* System.out.print()：不會自動換行，可印出任何資料型態 */
		System.out.print("c = " + c + "\td = " + d + "\n"); // "\t"是縮排；"\n"是換行

		/* System.out.printf()：可作範圍的計算，也可限定輸出的形式 */
		/* 「%d」為印出十進位的數字；「%s」為印出字串；「%c」為印出字元 */
		/* 應用：System.out.printf("%d", %d的值) */
		System.out.printf("byte值的範圍 %d ~ %d %n", Byte.MIN_VALUE, Byte.MAX_VALUE); // printf("%n")等同於print("\n")
		System.out.printf("short值的範圍 %d ~ %d %n", Short.MIN_VALUE, Short.MAX_VALUE);
		System.out.printf("int值的範圍 %d ~ %d %n", Integer.MIN_VALUE, Integer.MAX_VALUE); // 「int」是資料型態；「Integer」是物件
		System.out.printf("long值的範圍 %d ~ %d %n", Long.MIN_VALUE, Long.MAX_VALUE);

		/* 數字各種進位型態 */
		int aa;
		aa = 103; // 十進位：直接輸入
		System.out.println("列印103的值\t" + aa);
		aa = 0b11; // 二進位：以「0b」開頭
		System.out.println("列印0b11的值\t" + aa);
		aa = 022; // 八進位：以「0」開頭
		System.out.println("列印022的值\t" + aa);
		aa = 0x2B; // 十六進位：以「0x」開頭，字母盡量使用大寫方便區分
		System.out.println("列印0x2B的值\t" + aa);

		/* 字串型態 */
		char x = 'x'; // char宣告的值使用單引號且只能是字元，不能填入單字或句子
		char y = 65; // char宣告的數字會自動轉成Unicode的字母
		String z = "this is a string"; // 物件可以使用「變數.方法」快速選取要處理的方法

		System.out.println(x);
		System.out.println(y);
		System.out.println(z);

		/* boolean */
		boolean t = true; // 預設值是"false"

		/* 利用sysout判斷boolean */
		System.out.print("a<b: ");
		System.out.println(a < b);
		System.out.print("a>b: ");
		System.out.println(a > b);

		/* 實例練習 */
		int hourlySalary = 120;
		int workingHours = 8;
		int workingDays = 300;
		int totalSalary = hourlySalary * workingHours * workingDays;
		System.out.println("Total salary is\t" + totalSalary);
		int monthlyCost = 9000;
		int totalCost = monthlyCost * 12;
		System.out.println("Total cost is\t" + totalCost);
		int saveMoney = totalSalary - totalCost;
		System.out.println("Can save money\t" + saveMoney);

		/* 三元運算子 */
		/* 寫法：( 條件式 ? 滿足時顯示的值 : 不滿足時顯示的值 ) */
		String big = "bigger";
		String small = "smaller";
		System.out.println(5 > 4 ? big : small);
		System.out.println(3 > 4 ? big : small);
		
		/* 遞增在變數前後的區別*/
		int frontNum, backNum, value;
		frontNum = backNum = 10;
		value = ++frontNum * 5; // value = (+1) + a ==> 把變數的值賦予給左邊，再+1，再將新的值給左邊
		System.out.println("遞增在前面\t" + value);
		System.out.println("front number = " + frontNum);
		value = backNum++ * 5; // value = a + (+1) ==> 先把變數的值+1，再把新的值賦予給左邊
		System.out.println("遞增在後面\t" + value);
		System.out.println("back number = " + backNum);
		
		
		/* System.in */
		Scanner scan = new Scanner(System.in); // 如果Scanner出現紅蚯蚓，代表找不到來源，鼠標移到右邊的Scanner後選擇「import 'Scanner'(java.util)」
		int inputValue = scan.nextInt(); // 帶入數字
		String inputText = scan.next(); // 帶入文字
		System.out.println(inputValue + " " + inputText);
		
	}
	
	
	@Test
	public void errorTest() {
		
		// try catch
		Scanner scan = new Scanner(System.in);
		try{
			System.out.println("Please enter sth: ");
			String str = scan.next();
			System.out.println(str);
		} catch (Exception e) {
			System.out.println("some error happened!!");
		} finally { // finally無論成功與否都會執行
			scan.close();
		}
		
		// try-with-source：作用等同上面
		// 方法寫在try後面的()時，可以不用再寫finally把方法關掉
//		try (Scanner scann = new Scanner(System.in)){
//			System.out.println("Please enter sth: ");
//			String strr = scann.next();
//			System.out.println(strr);
//		} catch (Exception e) {
//			System.out.println("some error happened!!");
//		}
	}
	
	
	@Test
	public void errorThrowTest() throws Exception {
		String a = "12A";
		try {
			System.out.println(Integer.parseInt(a));
		} catch (Exception e) {
			throw new Exception(e.getMessage()); // 出現紅蚯蚓是因為method沒有加上throws的位置
		}
	}
}
