package com.example.demo.entity;

import com.example.demo.service.ifs.RunService; // import後，Class預設的變數名字會紅蚯蚓。解決：「Add unimplemented methods」（見第68行）

public class Dog implements RunService{
	
	/* Class屬性寫法：權限 資料型態 變數名稱 */
	/* 權限（=被存取權限）：public最大，全專案的範圍都可以用；private最小，只有宣告的該class可以使用 */
	private String name; // default值為null
	
	private String color; // default值為null
	
	private int age; // default值為0
	
	/* 在空白處右鍵，選擇「resource」「Generate Getter and Setter」建立以下方法 */
	public String getName() { // getter方法需要回傳值，因此要設置return
		return name;
	}

	public void setName(String name) { // void不回傳值，因此不需要return
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	/* 預設建構方法 */
	/* 在空白處右鍵，選擇「resource」「Generate constructor from superclass」建立以下方法*/
	/* 連DB時，如果沒有此行會報錯 */
	public Dog() {
		super();
	}

	/* 帶有屬性的建構方法 */
	/* 在空白處右鍵，選擇「resource」「Generate constructor using field」建立以下方法*/
	/* 建立時必須一起建立上面的預設建構方法 */
	public Dog(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}
	
	/* static的使用 */
	/* 注意：手打時需加上資料返回的型態（例如此處的void） */
	public void tryNoStatic() { // 沒有static的方法必須先new才能使用變數
		System.out.println("----");
	}
	public static void tryStatic() { // 有static的方法可以直接使用
		System.out.println("----");
	}

	/* implemented methods from Interface */
	@Override
	public void run() {
		System.out.println("Dogs are running");
		
	}
	
}
