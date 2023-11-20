package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuServiceModify;


@SpringBootTest 
public class MenuServiceTestModify {

	@Autowired
	private MenuServiceModify menuServiceModify;
	
	@Autowired
	private MenuDao menuDao;
	
	
	@Test
	public void addMenuTest() {
		
		// false：name不符合條件
		Menu result = menuServiceModify.addMenu(new Menu("", 120));
		Assert.isTrue(result == null, "addMenu error!");
		// false：price不符合條件
		result = menuServiceModify.addMenu(new Menu("beef", 0));
		Assert.isTrue(result == null, "addMenu error!");
		// false：新增者為已有相同名稱
		result = menuServiceModify.addMenu(new Menu("pork", 120));
		Assert.isTrue(result == null, "addMenu error!");
		// true：正常新增
		result = menuServiceModify.addMenu(new Menu("fish", 120));
		Assert.isTrue(result != null, "added.");
		
		// 測試完以上之後，刪除測試的資料
		menuDao.deleteById("fish");
		
	}
	
	
	@Test
	public void findByNameTest() {
		
		// false：name不符合條件
		Menu result = menuServiceModify.findByName("");
		Assert.isTrue(result == null, "couldn't find.");
		// false：name不存在
		result = menuServiceModify.findByName("cook");
		Assert.isTrue(result == null, "couldn't find.");
		// true：正常搜尋
		result = menuServiceModify.findByName("pork");
		Assert.isTrue(result != null, "found.");
		
	}
}
