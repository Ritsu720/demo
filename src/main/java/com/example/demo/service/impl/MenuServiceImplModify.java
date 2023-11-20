package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuServiceModify;

@Service
public class MenuServiceImplModify implements MenuServiceModify{

	@Autowired
	private MenuDao menuDao;
	
	
	
	@Override
	public Menu addMenu(Menu menu) {

		if (!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) {
			return null;
		}
		if (menuDao.existsById(menu.getName())) {
			return null;
		}
		return menuDao.save(menu);
	}

	@Override
	public List<Menu> addMenus(List<Menu> menu) {
		
		for (Menu item : menu) {
			if (!StringUtils.hasText(item.getName()) || item.getPrice() <= 0) {
				System.out.println("Enter incorrect!");
				return null;
			}
		}
		System.out.println(menu.toString());
		return menuDao.saveAll(menu);
	}

	@Override
	public Menu updateMenu(Menu menu) {
		
		/* 對比資料庫結果為false時，印出警告並不執行其他動作 */
		if(!menuDao.existsById(menu.getName())) { // 同等於：findList.isEmpty()
			System.out.println("No matching data found.");
			return null;
		}
		/* 對比資料庫結果為true時，將資料回傳並儲存*/
		return menuDao.save(menu);
	}

	@Override
	public Menu findByName(String name) {
		
		Optional<Menu> op = menuDao.findById(name);
		
		if(op.isEmpty()) {
			return null;
		}
		return op.get();
		
		// 如果都不需要sysout的話，可以直接寫這樣的三元式（出現的報錯問題尚未教到，待釐清）
//		return findList.isEmpty() ? null : findList.get();
		
		// 或者以下
//		retrun findList.orElseGet(null);
	}

	@Override
	public List<Menu> findAll(List<Menu> menu) {
		return menuDao.findAll();
		
	}

}
