package com.example.demo.service.ifs;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.PersonInfo;

public interface PersonInfoService {

	public void addInfo(PersonInfo info);
	
	public void addInfoList(List<PersonInfo> infoList);
	
	// 以下為11/13新增
	public PersonInfo addPersonInfo(PersonInfo personInfo);
	
	public List<PersonInfo> addPersonInfoList(List<PersonInfo> personInfoList);
	
	public List<PersonInfo> getInfo();
	
	public Optional<PersonInfo> getInfoById(String id);

}
