package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;
import com.example.demo.repository.MealDao;
import com.example.demo.service.ifs.MealService;

@SpringBootTest
public class MealServiceTest {
	
	@Autowired
	private MealService mealService;
	@Autowired
	private MealDao mealDao;
	
	/* 測試addMeal */
	@Test
	public void addMealTest() {
		
		// false：name不符合
		Meal result = mealService.addMeal(new Meal("", "steam", 180));
		Assert.isTrue(result == null, "addMeal error!");
		
		// false：cookingStyle不符合
		result = mealService.addMeal(new Meal("pork", "", 180));
		Assert.isTrue(result == null, "addMeal error!");
		
		// false：price不符合
		result = mealService.addMeal(new Meal("pork", "steam", 0));
		Assert.isTrue(result == null, "addMeal error!");
		
		// true：正常新增
		result = mealService.addMeal(new Meal("pork", "steam", 120));
		Assert.isTrue(result != null, "addMeal error!");
		
		// false：新增相同
		result = mealService.addMeal(new Meal("pork", "steam", 10));
		Assert.isTrue(result == null, "addMeal error!");
		
		// 刪除測試資料
		mealDao.deleteById(new MealId("pork", "steam"));
		
	}
	
	
	/* 預設資料 */
	@Test
	public void addMealNewTest() {
		
		mealService.addMeal(new Meal("pork", "fried", 120));
		mealService.addMeal(new Meal("beef", "BBQ", 150));
		mealService.addMeal(new Meal("beef", "fry", 130));
		mealService.addMeal(new Meal("chicken", "stew", 120));
		mealService.addMeal(new Meal("chicken", "BBQ", 100));
		mealService.addMeal(new Meal("chicken", "steam", 120));
		
	}
	
	
	/* limit（限制回傳筆數）使用 */
	@Test
	public void limitTest() {
		List<Meal> res = mealDao.findTop2ByName("chicken");
		System.out.println(res.size());
		Assert.isTrue(res.size() == 2, "find_limit_error");
	}
	
	
	/* 排序 */
	@Test
	public void orderTest() {
		List<Meal> res = mealDao.findAllByOrderByPrice(); // 正序的用法
//		List<Meal> res = mealDao.findAllByOrderByPriceDesc(); // 倒序的用法
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + " " +  item.getPrice());
		}
	}

	
	/* 比較大小 */
	@Test
	public void compareTest() {
		List<Meal> res = mealDao.findByPriceGreaterThan(150); // price > 150
//		List<Meal> res = mealDao.findByNameAndPriceGreaterThan("chicken", 150); // price > 150 && name == "chicken"
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + " " +  item.getPrice());
		}
	}
	
	
	/* 包含（類似模糊搜尋）*/
	@Test
	public void containingTest() {
		List<Meal> res = mealDao.findByNameContaining("e");
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + " " +  item.getPrice());
		}
	}
	
	
	/* Between */
	@Test
	public void betweenTest() {
		List<Meal> res = mealDao.findByPriceBetween(150, 300);
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + " " +  item.getPrice());
		}
	}
	
	
	/* In */
	@Test
	public void inTest() {
		// 從list裡面的條件找出符合的
		List<Meal> res = mealDao.findByPriceInOrderByPrice(new ArrayList<>(List.of(120, 130, 150, 180, 200)));
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + " " +  item.getPrice());
		}
	}
}
