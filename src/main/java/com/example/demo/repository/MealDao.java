package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId>{

	/* 限制搜尋結果的回傳筆數 */
	// findTop(n)
	public List<Meal> findTop2ByName(String name);
	// findFirst(n)
	public List<Meal> findFirst2ByName(String name); // findFirst(n)與findTop(n)作用一樣
	
	
	/* 排序，預設為ASC */
	/* ASC：由小到大；DESC：由大到小 */
	public List<Meal> findAllByOrderByPrice(); // findAll後面用OrderBy時，必在兩者間用"By"
	public List<Meal> findAllByOrderByPriceDesc(); // 倒序排列
	
	
	/* 比大小 */
	// GreaterThan：大於
	// GreaterThanEqual：大於等於
	// LessThan：小於
	// LessThanEqual：小於等於
	public List<Meal> findByPriceGreaterThan(int price);
	public List<Meal> findByNameAndPriceGreaterThan(String name, int price);
	
	
	/* 類似模糊搜尋 */
	// containing
	public List<Meal> findByNameContaining(String name); // 多項搜尋時可直接用"And"或"Or"串接，會忽略大小寫
	
	
	/* 範圍搜尋 */
	// between
	public List<Meal> findByPriceBetween(int priceMin, int priceMax); // 搜尋結果有包含min和MAX的值
	// in
	public List<Meal> findByPriceIn(List<Integer> priceList); // 太死了不常用
	public List<Meal> findByPriceInOrderByPrice(List<Integer> priceList); // 組合OrderBy應用
	
	
	
}
