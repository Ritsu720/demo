package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@SpringBootTest
public class PersonInfoTest {

	@Autowired
	public PersonInfoService personInfoService;
	
	@Autowired
	public PersonInfoDao personInfoDao;
	
	
	/* 使用input測試資料的連結 */
	@Test
	public void infoTest() {
		
		/* input the value */
		System.out.println("Please enter the ID, name, age, city below:");
		Scanner scan = new Scanner(System.in);
		
		String id = scan.next();
		String name = scan.next();
		int age = scan.nextInt();
		String city = scan.next();
		
		/* set the data to the DB */
		personInfoService.addInfo(new PersonInfo(id, name, age, city));
	}
	
	
	/* 使用Service implements新增List */
	@Test
	public void infoListTest() {
		
		
		List<PersonInfo> listImpl = new ArrayList<>();
		
		listImpl.add(new PersonInfo("C123456789", "CC", 30, "Tainan"));
		listImpl.add(new PersonInfo("C223456789", "Cc", 35, "Tainan"));
		
		personInfoService.addInfoList(listImpl);
	}
	
	
	/* .saveAll */
	@Test
	public void daoTest() {
		
		List<PersonInfo> list = new ArrayList<>();
		
		list.add(new PersonInfo("B123456789", "BB", 30, "Taipei"));
		list.add(new PersonInfo("B223456789", "Bb", 35, "Taipei"));
		
		personInfoDao.saveAll(list); // ".saveAll"為全部儲存，後面要放List<>
		
	}
	
	/* .findById */
	@Test
	public void daoFindTest() {
		
		// 直接輸入變數名，選擇「Create local variable 'info'」宣告.findById的變數
		// 只有.findById的資料型態是Optional!!
		Optional<PersonInfo> infoOp = personInfoDao.findById("B223456789"); // id為MySQL中的primary key，即在entity內的"@Id"
		
		if(infoOp.isEmpty()) { // .isPresent和.isEmpty完全相反
			System.out.println("Not found!");
			return;
		}
		// 因為資料型態是Optional，必須先.get獲取到Class PersonInfo，再獲取Class PersonInfo內的methods
		System.out.println(infoOp.get().getName()); 

	}
	
	
	/* .findAll */
	@Test
	public void daoFindAllTest() {
		
		List<PersonInfo> list = personInfoDao.findAll();
		
		for (PersonInfo item : list) {
			System.out.println(item.getName());
		}
		
	}
	
	
	/* .exists */
	/* 應用方法：註冊時把email設成primary key，避免重複email的狀況 */
	@Test
	public void exsistsTest() {
		
		boolean result = personInfoDao.existsById("B223456789");
		System.out.println(result);
		
	}
	
	
	/* 使用Dao自建搜尋（Read）的method */
	@Test
	public void daoReadTest() {
		
		List<PersonInfo> result = personInfoDao.findByCity("Tainan");
		
//		List<PersonInfo> result = personInfoDao.findByNameAndCity("Cc", "Tainan"); // And method
//		List<PersonInfo> result = personInfoDao.findByNameOrCity("B", "Tainan"); // Or method
		
		System.out.println(result.size() + " matched data found."); // 因為result是List，直接印出的話會顯示儲存位置，此處選擇用長度
		
		for(PersonInfo item : result) {
			System.out.println(item.getName());
		}
		
	}
	

	
	
	// 以下為11/13新增練習
	
	
	
	
	/* getInfo */
	@Test
	public void getInfoTest() {
		List<PersonInfo> result = personInfoService.getInfo();
		for(PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() 
				+ " " + item.getCity() );
		}
	}
	
	
	/* getInfoById */
	@Test
	public void getInfoByIdTest() {
		// false：id不符合格式
		Optional<PersonInfo> result = personInfoService.getInfoById("");
		Assert.isTrue(result == null, "get_info_error");
		// true：id符合格式
		result = personInfoService.getInfoById("A123456789");
		Assert.isTrue(result != null, "get_info_error");
	}
	
	
	/* GreaterThan */
	@Test
	public void greaterThanTest() {
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThan(20);
		for(PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() 
				+ " " + item.getCity() );
		}
	}
	
	
	/* LessThanEqual */
	@Test
	public void lessThanEqualTest() {
		List<PersonInfo> result = personInfoDao.findByAgeLessThanEqualOrderByAge(30);
		for(PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() 
				+ " " + item.getCity() );
		}
	}
	
	
	/* Or */
	@Test
	public void orTest() {
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThanOrAgeLessThanEqual(25, 20);
		for(PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() 
				+ " " + item.getCity() );
		}
	}
	
	
	/* Between */
	@Test
	public void betweenTest() {
		List<PersonInfo> result = personInfoDao.findTop3ByAgeBetweenOrderByAgeDesc(10, 30);
		for(PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() 
				+ " " + item.getCity() );
		}
	}
	
	
	/* Containing */
	@Test
	public void containingTest() {
		List<PersonInfo> result = personInfoDao.findByCityContaining("n");
		for(PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() 
				+ " " + item.getCity() );
		}
	}
	
	
	/* And */
	@Test
	public void andTest() {
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(20, "T");
		for(PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() 
				+ " " + item.getCity() );
		}
	}
	
}
