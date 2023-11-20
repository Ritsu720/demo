package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@SpringBootTest
public class AtmServiceTest {

	
	@Autowired
	private AtmService atmService;
	
	
	@Test
	public void addInfoTest() {
		
		AtmResponse atmRes = atmService.addInfo("A01", "A123");
		
		System.out.println(atmRes.getAtm().getAccount());
		System.out.println(atmRes.getAtm().getPwd());
		System.out.println(atmRes.getRtnCode().getCode());
		System.out.println(atmRes.getRtnCode().getMessage());
		
	}
	
	
	
	@Test
	public void depositeTest() {
		
		AtmResponse atmRes = atmService.deposite("A01", "A123", 10000);
		
//		System.out.println(atmRes.getAtm().getAccount());  // 如果account, pwd, amount不符合規定的話，這兩行會報錯
//		System.out.println(atmRes.getAtm().getBalance());
		System.out.println(atmRes.getRtnCode().getCode() + atmRes.getRtnCode().getMessage());

	}
	
	
	@Test
	public void withdrawTest() {
		
		AtmResponse atmRes = atmService.withdraw("A01", "A123", 10000);
		
//		System.out.println(atmRes.getAtm().getAccount());
//		System.out.println(atmRes.getAtm().getBalance());
		System.out.println(atmRes.getRtnCode().getCode() + atmRes.getRtnCode().getMessage());
	}
}
