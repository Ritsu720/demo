package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;
import com.example.demo.repository.AtmDao;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;


@Service
public class AtmServiceImpl implements AtmService{
	
	/* 使用多次的參數可以直接拉出來變成全域使用 */
	// 密碼加密，共60碼（記得檢查DB的字元數是否也是60）
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private AtmDao atmDao;
	
	
	/* 測試session&cache用 */
	@Override
	public AtmResponse login(String account, String pwd) {
		
		/* check account & pwd has text in */
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		
		/* find the data by id, and check if it's existed */
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		
		/* check the pwd */
		if(encoder.matches(pwd, op.get().getPwd())) {
			return new AtmResponse(null, RtnCode.LOGIN_ERROR);
		}
		return new AtmResponse(null, RtnCode.SUCCESSFUL);
	}
	
	
	
	@Override
	public AtmResponse addInfo(String account, String pwd) {
		
		String accountPatern = "^\\w{3,8}$";
		String pwdPattern = "^.*\\W+.*$";
		
		/* check account */
		if(!StringUtils.hasText(account) || !account.matches(accountPatern)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		/* check pwd */
		if(!StringUtils.hasText(pwd) || !pwd.matches(pwdPattern) || pwd.length() < 8 || pwd.length() > 16) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		
		/* 檢查資料庫中是否有相同account */
		if(atmDao.existsById(account)) {
			return new AtmResponse(null, RtnCode.ACCOUNT_EXISTED);
		}
		
		/* 以上都檢查正確後，儲存到資料庫 */
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd)));
//		res.setPwd(""); // 不想顯示密碼在console的話加上此行
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}


	@Override
	@Cacheable(cacheNames = "atm_get_balance", key = "#account", unless = "#result.rtnCode.code != 200")
	public AtmResponse getBalanceByAccount(String account, String pwd) {
		
		/* account或pwd為空時return null */
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		
		/* 檢查資料庫內是否存在此帳號的資料 */
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		/* 把密碼加密後對比資料庫的已加密密碼 */
		Atm res = op.get();
		// 使用.matches(原生密碼, 加密後密碼)比對是否符合
		if(!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}


	@Override
	public AtmResponse updatePwd(String account, String oldPwd, String newPwd) {
		
		if(!StringUtils.hasText(account) || !StringUtils.hasText(oldPwd) || !StringUtils.hasText(newPwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		
		/* 檢查資料庫內是否存在此帳號的資料 */
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		
		/* 把密碼加密後對比資料庫的已加密密碼 */
		Atm res = op.get();
		// 使用.matches(原生密碼, 加密後密碼)比對是否符合
		if(!encoder.matches(oldPwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		res.setPwd(encoder.encode(newPwd)); // 把新密碼加密後存到Entity Atm
		atmDao.save(res); // 把加密後的密碼儲存到資料庫
		res.setPwd(""); // return的密碼用空字串隱藏
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}


	@Override
	public AtmResponse deposite(String account, String pwd, int amount) {
		
		/* 帳號密碼不得為空，新增不得為0或負數 */
		if( !StringUtils.hasText(account) || !StringUtils.hasText(pwd) || amount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		/* 帳號是否存在於資料庫中 */
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		/* 比對密碼 */
		Atm res = op.get();
		if(!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		
		/* 新增amount */
		res.setBalance(res.getBalance() + amount);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}


	@Override
	public AtmResponse withdraw(String account, String pwd, int amount) {
		
		/* 帳號密碼不得為空，提款不得為0或負數 */
		if( !StringUtils.hasText(account) || !StringUtils.hasText(pwd) || amount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		/* 帳號是否存在於資料庫中 */
		Optional<Atm> op = atmDao.findById(account);
		if(op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		/* 比對密碼 */
		Atm res = op.get();
		if(!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		
		/* 比對提款是否比餘額多 */
		if(amount > res.getBalance()) {
			res.setPwd("");
			return new AtmResponse(res, RtnCode.INSUFFICIENT_BALANCE);
		}
		
		/* 提出amount */
		res.setBalance(res.getBalance() - amount);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}


	

}
