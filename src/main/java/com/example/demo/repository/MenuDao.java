package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;

/* Data Access Object：將資料從資料庫提取的接口 */
@Repository // 用spring boot託管
public interface MenuDao extends JpaRepository<Menu, String>{ // T：demo.entity；ID：primary key的資料型態（只能擇一）

//	public List<Menu> updateMenu(String name, int price);
	
	public List<Menu> findByName(String name);
	
}
