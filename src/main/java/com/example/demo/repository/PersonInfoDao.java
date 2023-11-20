package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;


@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String>{
	
	/* 自建Read method*/
	public List<PersonInfo> findByCity(String city); // 非單一筆資料的話，都用List接回
	
	public List<PersonInfo> findByNameAndCity(String name, String city);
	
	public List<PersonInfo> findByNameOrCity(String name, String city);

	
	
	// 以下為11/13新增
	
	
	// age大於
	public List<PersonInfo> findByAgeGreaterThan(int age);
	// age小於等於
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age);
	// age小於等於
	public List<PersonInfo> findByAgeGreaterThanOrAgeLessThanEqual(int ageGreater, int ageLess);
	// age介於min和MAX之間，並只顯示前三筆資料
	public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeDesc(int ageMin, int ageMax);
	// Containing
	public List<PersonInfo> findByCityContaining(String city);
	// And
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age, String city);
	
}
