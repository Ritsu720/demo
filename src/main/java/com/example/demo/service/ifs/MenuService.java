package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.Menu;

/* 負責提供methods的種類 */
public interface MenuService {

	public void addMenu(Menu menu); // import 「entity」
	
	public void addMenus(List<Menu> menu);
	
	public void updateMenu(Menu menu);
	
	public void findByName(String name);
	
}
