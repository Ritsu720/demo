package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class RegexTest {
	
	/* regex正規表達式 */
	@Test
	public void regexTest() {
		
		/* 台灣手機格式 */
		String phone = "0912-345-678";
		String pattern = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d"; // 第一個的「\」是跳脫符號，會使後面的字元變成無意義
		String pattern1 = "\\d{4}-\\d{3}-\\d{3}"; // {}內數字代表重複的次數，此行作用等於上一行
		String pattern2 = "\\d{4}(-\\d{3}){2}"; // 重複的字元片段可以直接用()框起來，後面加上{}重複的次數，此行作用等於上上行
		System.out.println(phone.matches(pattern)); // 使用「.matches」把要比對的格式放在()內
		System.out.println("---------------");
		
		/* 常用特殊字元 */
		String check = "A1";
		String check1 = "A123";
		
		// 檢查的樣式
		String checkPattern = "\\w."; // "."代表萬用字元
		String checkPattern1 = "\\w.?"; // "?"代表重複0~1次
		String checkPattern2 = "\\w.*"; // "*"代表重複0~多次
		String checkPattern3 = "\\w.+"; // "*"代表重複1~多次
		// 印出檢查"A1"
		System.out.println(check.matches(checkPattern)); // t
		System.out.println(check.matches(checkPattern1)); // t
		System.out.println(check.matches(checkPattern2)); // t
		System.out.println(check.matches(checkPattern3)); // t
		System.out.println("---------------");
		// 印出檢查"A123"
		System.out.println(check1.matches(checkPattern)); // f
		System.out.println(check1.matches(checkPattern1)); // f
		System.out.println(check1.matches(checkPattern2)); // t
		System.out.println(check.matches(checkPattern3)); // t
	}
	
	
	/* 身分證格式比對 */
	@Test
	public void telePractice() {
		Scanner scan = new Scanner(System.in);
		
//		String telePattern = "\\(\\d{2}\\)\\d{8}";
//		String telePattern1 = "\\(\\d{2}\\)\\d{7}";
//		String telePattern2 = "\\d{2}-\\d{8}";
//		String telePattern3 = "\\d{2}-\\d{7}";
		
		String telePattern = "^(\\(\\d{2,4}\\)|\\d{2,4}-)\\d{7,8}$"; // 精簡以上四行並加上區碼為3or4碼的情況，"|"為或的符號，"^"為開頭標記"$"為結尾標記
		
		while(true) {
			System.out.println("Enter the telephone number:");
			String tele = scan.next();
			
			if(tele.matches(telePattern)) {
				System.out.println("Format correct.");
				break;
			} else {
				System.out.println("Format not correct!");
			}
		}
	}
	
	
	/* 身分證格式比對 */
	@Test
	public void idcardPractice() {
		String pattern = "[A-Za-z][1,2]\\d{8}"; // 最簡單條件：第一位為英文字母、第二位為1or2、總共八碼
		String pattern1 = "[CGI-Zcgi-z][1,2]\\d{8}"; // 暴力排除六都的ABDEFH
		String pattern2 = "[A-Z&&[^ABDEFH]a-z&&[^abdefh]][1,2]\\d{8}"; // 使用特殊字元^（範圍用[]框起來）排除六都的ABDEFH
		
		for(;;) {
			System.out.println("Please enter the number of identity card:");
			Scanner scan = new Scanner(System.in);
			String id = scan.next();
			
			if(id.matches(pattern2)) {
				System.out.println( id + ": Format correct.");
				break;
			} else {
				System.out.println( id + ": Format incorrect.");
			}
			
		}
		
	}

}
