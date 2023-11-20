package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

@SpringBootTest // 捕捉所有spring boot託管的東西。如果有寫"@Autowired"的話必加此行
public class MenuServiceTest {
	
	@Autowired
	private MenuService menuService; // 把託管的serve拉回來
	@Autowired
	private MenuDao menuDao;

	
	/* add menu */
	@Test
	public void addMenuTest() {
		
		menuService.addMenu(new Menu("Pork", 100)); // import entity
		
	}
	
	
	/* add menus*/
	@Test
	public void addMenusTest() {
		
		List<Menu> list = new ArrayList<>();
		
		list.add(new Menu("Beef", 170));
		list.add(new Menu("Seafood", 200));
		
		menuService.addMenus(list);
		
	}
	
	
	/* update menu */
	@Test
	public void updateMenuTest() {
		
		String name = "pork";
		int price = 100;
		
		menuService.updateMenu(new Menu(name, price));
		
	}
	
	
	/* find by name */
	@Test
	public void findByNameTest() {
		
		String targetName = "pork";
		
		menuService.findByName(targetName);
	}
	
	
	/* find all */
	@Test
	public void findAllTest() {
		
		List<Menu> list = menuDao.findAll();
		
		for(Menu item : list) {
			System.out.println(item.getName() + item.getPrice());
		}
		
	}
}
