package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.Menu;

public interface MenuServiceModify {

	public Menu addMenu(Menu menu);
	
	public List<Menu> addMenus(List<Menu> menu);
	
	public Menu updateMenu(Menu menu);
	
	public Menu findByName(String name);
	
	public List<Menu> findAll(List<Menu> menu);
}
