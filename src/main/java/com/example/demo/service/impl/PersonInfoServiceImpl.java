package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.MealId;
import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;


@Service
public class PersonInfoServiceImpl implements PersonInfoService{
	
	@Autowired
	private PersonInfoDao personInfoDao;

	
	/* methods */
	@Override
	public void addInfo(PersonInfo info) {
		
		String pattern = "[A-Za-z][1,2]\\d{8}";
		
		String id = info.getId();
		
		if (StringUtils.hasText(id) && id.matches(pattern)) {
			
			personInfoDao.save(info);
			System.out.println("Id confirm.");
			
		} else {
			
			System.out.println("Id format incorrect.");
			
		}
		
	}
	
	
	@Override
	public void addInfoList(List<PersonInfo> infoList) {
		
		String pattern = "[A-Za-z][1,2]\\d{8}";
		
		for(PersonInfo item : infoList) {
			String id = item.getId();
			
			if(!StringUtils.hasText(id) || !(id.matches(pattern))) {
				System.out.println(id + ": Format incorrect.");
				return; // saving 0 or all
			}
		}
		personInfoDao.saveAll(infoList); // saving 0 or all
	}


	
	
	// 以下為11/13新增
	
	
	
	@Override
	public PersonInfo addPersonInfo(PersonInfo personInfo) {
		
		String pattern = "[A-Za-z][1,2]\\d{8}";
		
		if(!personInfo.getId().matches(pattern) && !StringUtils.hasText(personInfo.getId()) 
				|| personInfo.getName().isEmpty() || personInfo.getAge() <= 0 || personInfo.getCity().isEmpty()) {
			return null;
		}
		if(personInfoDao.existsById(personInfo.getId())) {
			return null;
		}
		return personInfoDao.save(personInfo);
	}


	@Override
	public List<PersonInfo> addPersonInfoList(List<PersonInfo> personInfoList) {
		
		String pattern = "[A-Za-z][1,2]\\d{8}";
		
		for(PersonInfo item : personInfoList) {
			if(!item.getId().matches(pattern) && !StringUtils.hasText(item.getId()) || item.getName().isEmpty()
					|| item.getAge() <= 0 || item.getCity().isEmpty()) {
				return null;
			}
			if(personInfoDao.existsById(item.getId())) {
				return null;
			}
		}
		return personInfoDao.saveAll(personInfoList);
	}
	
	
	
	@Override
	public List<PersonInfo> getInfo() {
		
		return personInfoDao.findAll();
		
	}


	@Override
	public Optional<PersonInfo> getInfoById(String id) {
		
		String pattern = "[A-Za-z][1,2]\\d{8}";
		
		if(!id.matches(pattern)) {
			return null;
		}
		return personInfoDao.findById(id);
	}


	
	

}
