package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//import org.assertj.core.util.Arrays; // 在Test中使用Arrays時要記得檢查有無這行，如果有則會報錯
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

public class StringTest {

	/* 字串的存放邏輯 */
	@Test
	public void stringEqualsTest() {
		
		/* 參照與副本的差異 */
		String str1 = "ABC"; // 在String Pool內建立一個空間給"ABC"
		String str2 = new String("ABC"); // 在String Pool內新建立一個空間給"ABC"
		String str3 = "ABC"; // 在String Pool內找到已有"ABC"的空間，直接取用
		System.out.println("str1 == str2 " + (str1 == str2)); // 「false」
		System.out.println("str1 == str3 " + (str1 == str3)); // 「true」
		System.out.println("-------------------------");
		
		/* 只比較值 */
		System.out.println("str1.equals(str2) " + str1.equals(str2));
		System.out.println("str1.equals(str3) " + str1.equals(str3));
		System.out.println("-------------------------");
		
		/* 「.equalsIgnoreCase」忽略大小寫後比較*/
		String str4 = "abc";
		System.out.println("str1.equals(str4) " + str1.equals(str4));
		System.out.println("str1.equalsIgnoreCase(str4) " + str1.equalsIgnoreCase(str4));
		
	}
	
	
	/* length、isEmpty、isBlanck的檢查 */
	@Test
	public void stringCheckTest(){
		
		String abc = "ABC";
		String empty = "";
		String space = "  ";
		
		/* length檢查 */
		System.out.println("str length: " + abc.length());
		System.out.println("empty length: " + empty.length());
		System.out.println("space length: " + space.length());
		System.out.println("-------------------------");
		
		/* isEmpty()檢查*/
		System.out.println("empty isEmpty: " + empty.isEmpty());
		System.out.println("space isEmpty: " + space.isEmpty());
		System.out.println("-------------------------");
		
		/* isBlank()檢查*/
		System.out.println("empty isBlanck: " + empty.isBlank());
		System.out.println("space isBlanck: " + space.isBlank());
	}
	
	/* StringUtils + .hasLength & .hasText */
	@Test
	public void stringTest() {
		
		String str; // 如果使用「.length」印出結果會報錯，因為字串的default value是「null」
//		System.out.println(str == null); // 直接寫會報錯，因為沒有宣告字串的值
		
		/* 判斷是否為空 */
		String strNull = null; // 假設已經宣告了一個default value的變數並引用進來，此處為了方便查看結果，故直接宣告
		if(strNull == null || strNull.isBlank()) { // 在判斷字串是否為空時，應該要先判斷是否為null，否則會報錯
			System.out.println("strNull is blank.");
		} else {
			System.out.println("strNull is NOT blank");
		}
		System.out.println("-------------------------");
		
		/* StringUtils.hasText檢查是否為null、是否為空 */
		String strBlank = " ";
		/* .hasLength接近於.isBlank，空格的情況會被視作true */
		System.out.println(".hasLength: " + StringUtils.hasLength(strBlank));
		System.out.println(".isBlank: " + strBlank.isBlank());
		/* .hasText接近於.isEmpty，空格的情況會被視作false */
		System.out.println(".hasText: " + StringUtils.hasText(strBlank));
		System.out.println(".isEmpty: " + strBlank.isEmpty());
		System.out.println("-------------------------");
		/* 使用「StrinUtils.hasText」檢查是否為null或內容為空白 */
		if(!StringUtils.hasText(strNull)) { // 假如有字就會是true，因此要判斷沒有字的情況，前面加上「!」即可
			System.out.println("is null or blank.");
		} else {
			System.out.println("is NOT null or blank.");
		}
		
	}
	
	
	/* String練習：找出「小龍女」的目錄位置和數量 */
	@Test
	public void stringPractice() {
		
		String sentence = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		
//		System.out.println(sentence.indexOf("小龍女")); // 8
////		System.out.println(sentence.lastIndexOf("小龍女")); // 確認最後一個指定字元的index值
//		System.out.println(sentence.indexOf("小龍女", 11)); //19
//		System.out.println(sentence.indexOf("小龍女", 22)); //28
//		System.out.println(sentence.indexOf("小龍女", 31)); // 找不到指定字元，回傳「-1」
		
		int count = 0;
		String find = "小龍女";
		int index = 0;
		
		/* 自己寫 */
//		for(int i = 0; i < sentence.length(); i++) {
//			if(sentence.indexOf(find, i) != -1) {
//				i = sentence.indexOf(find, i);
//				System.out.println(i);
//				count++;
//			} else {
//				break;
//			}
//		}
		/* 修正後 */
//		for(int i = 0; i < sentence.length(); i++) {
//			if((index = sentence.indexOf(find, index)) != -1) {
//				System.out.println(index);
//				index = index + find.length();
//				count++;
//			} else {
//				break;
//			}
//		}
		/* 用while迴圈再修改 */
		while((index = sentence.indexOf(find, index)) != -1) {
			System.out.println(index);
			index += find.length();
			count++;
		}
		System.out.println("total count is: " + count);
		
	}
	
	
	/* .replace用法 */
	@Test
	public void replaceTest() {
		String sentence = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，" 
				+ "雖然小龍女在楊過眼中是清新脫俗";
		
		/* 「.replace」全部更改 */
		sentence = sentence.replace("小龍女", "小籠包");
		System.out.println(sentence);
		System.out.println("-------------------------");
		/* 「.replaceAll」正規表達式的全部更改 */
		sentence = sentence.replaceAll("小籠包", "小籠湯包");
		System.out.println(sentence);
		System.out.println("-------------------------");
		/* 「.replaceFirst」只更改第一個 */
		sentence = sentence.replaceFirst("小籠湯包", "蒸餃");
		System.out.println(sentence);
		
	}
	
	
	/* .split用法 */
	@Test
	public void splitTest() {
		String sentence = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，" 
				+ "雖然小龍女在楊過眼中是清新脫俗";
		
		/* 用「.split」以關鍵字切開 */
		String[] senArr= sentence.split("小龍女"); // 以"小龍女"為關鍵字斷開，不保留關鍵字
		for (String target : senArr) {
			System.out.println(target);
		}
		/* 用「.split」以空字串切開 */
		String str = "ABCD";
		String[] strArr = str.split("");
		for (String target : strArr) {
			System.out.println(target);
		}
		
	}
	
	
	/* .trim用法 */
	@Test
	public void trimTest() {
		String str = "ABC DEF "; // 後方有空格
		String str1 = " ABC DEF "; //前後都有空格
		/* trim消掉前後的空格 */
		System.out.println(str + str1);
		str = str.trim();
		str1 = str1.trim();
		System.out.println(str + str1);
		/* replace消掉全部的空格 */
		str = str.replace(" ", "");
		System.out.println(str);
		
	}
	
	
	/* .substring用法 */
	@Test
	public void substringTest() {
		String sentence = "神鵰俠侶是楊過與小龍女的故事";
		
		String subStr = sentence.substring(5); // 從index=5的位置開始擷取
		System.out.println(subStr);
		
		String subStrToEnd = sentence.substring(5, 11); // 從index=5的位置開始擷取，到index=11-1的位置停止
		System.out.println(subStrToEnd);
	}
	
	
	/* StringBuffer用法 */
	@Test
	public void stringBufferTest() {
		/* 連接字串 */
		StringBuffer sb = new StringBuffer("ABC");
		sb.append("DEF");
		sb.append("G");
		sb.append("TEXT").append("STH");
		System.out.println(sb);
		/* StringBuffer的比較 */
		StringBuffer sb1 = new StringBuffer("ABC");
		StringBuffer sb2 = new StringBuffer("ABC");
		System.out.println(sb1.equals(sb2)); // StringBuffer可以串接字串，但不是字串，因此會比較的是兩者的記憶體位置
		System.out.println(sb1.toString().equals(sb2.toString())); // 使用toString將兩者都轉換為字串，再做比較
	}
	
	
	/* StringBuffer應用 */
	/* 把最後一個A換成W */
	@Test
	public void stringbufferSetCharAt() {
		
		StringBuffer words = new StringBuffer("ABACADEF");
		System.out.println("The original words: " + words);
		int index = words.lastIndexOf("A");
		words.setCharAt(index, 'W'); // 注意「.setCharAt」只能使用字元（單引號），不能使用字串（雙引號）
		System.out.println("The changed words: " + words);
		
	}
	
	
	/* StringBuffer應用 */
	/* 判斷是否為迴文 */
	@Test
	public void stringbufferReverse() {
		
		Scanner scan = new Scanner(System.in);
		
		for (;;) {
			/* 輸入要檢查的字串 */
			System.out.println("Please enter a string to check:");
			String str = scan.next();
			
			/* 如果是單字元或空白不算是迴文，因此返回到輸入的地方 */
			if(str.length() <= 1) {
				continue;
			}
			
			/* 設定一個StringBuffer */
			StringBuffer sb = new StringBuffer(str);
			/* 如果str與str.reverse相同即為迴文*/
			if(str.equals(sb.reverse().toString())) {
				System.out.println("==");
			} else {
				System.out.println("!=");
			}
			break;
		}
		
	}
	
	
	/* String.valueOf、List應用 */
	/* 將輸入值+1後轉成陣列印出 */
	@Test
	public void listPractice() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		/* 獲取輸入值並+1 */
		int inputInt = scan.nextInt();
		inputInt++;
		/* 將數字改成字串，並將每個字元分出來到一個陣列中*/
		String inputStr = String.valueOf(inputInt); // 將數字轉成字串：String.valueOf()
		String[] strArray = inputStr.split("");
		List <String> intList = new ArrayList<>(Arrays.asList(strArray));
		System.out.println(intList);
		
		
	}
}
