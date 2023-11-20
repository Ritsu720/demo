package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

/* 負責提供methods的內容 */
@Service // 用spring boot託管
public class MenuServiceImpl implements MenuService{ // implements輸入進來後，class名會出現紅蚯蚓，鼠標移過去選取「Add unimplemented methods」
	
	// @: annotation
	@Autowired // 把被spring boot託管的東西呼叫出來使用
	private MenuDao menuDao;


	// methods
	@Override
	public void addMenu(Menu menu) {

		if (!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) {
			System.out.println("Enter incorrect!");
			return;
		}
		System.out.println(menu.getName() + menu.getPrice());
//		menuDao.save(menu); // JPA裡面的方法「.save」可以將資料儲存到資料庫
		
	}

	@Override
	public void addMenus(List<Menu> menu) {
		
		for (Menu item : menu) {
			if (!StringUtils.hasText(item.getName()) || item.getPrice() <= 0) {
				System.out.println("Enter incorrect!");
				return;
			}
			System.out.println(item.getName() + item.getPrice());
		}
		menuDao.saveAll(menu);
		
	}

	@Override
	public void updateMenu(Menu menu) {
		
		/* 宣告name & price */
		String name = menu.getName();
		int price = menu.getPrice();
		
		/* find list */
		List<Menu> findList = menuDao.findByName(name);
		
		/* 對比資料庫結果為false時，印出警告並不執行其他動作 */
		if(findList.isEmpty()) { // 同等於：findList.isEmpty()
			System.out.println("No matching data found.");
			return;
		}
		/* 對比資料庫結果為true時，印出原始和變更的內容，並將資料回傳並儲存*/
		for (Menu item : findList) {
			System.out.println("The original name and price is: " + item.getName() + item.getPrice());
		}
		System.out.println("The name and price changed to: " + name + price);
		menuDao.save(menu);
		
		
	}


	@Override
	public void findByName(String name) {
		
		List<Menu> findList = menuDao.findByName(name);
		
		/* find list為空時，印出警告並不執行其他動作 */
		if(findList.isEmpty()) {
			System.out.println("No matching data found.");
			return;
		}
		/* find list有值時遍歷印出*/
		for (Menu item : findList) {
			System.out.println(item.getName() + item.getPrice());
		}
		
	}

}
