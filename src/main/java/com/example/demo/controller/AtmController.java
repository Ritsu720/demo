package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.RtnCode;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmRequest;
import com.example.demo.vo.AtmResponse;

@RestController
public class AtmController {
	
	
	@Autowired
	private AtmService atmService;
	
	
	
	
	/* session for login */
	// only use session
	@GetMapping(value = "atm/login")
	public AtmResponse login(@RequestBody AtmRequest req, HttpSession session) {
		
		// 如果session內已存在相同帳號密碼，則直接回傳成功（不需要回傳值，因為已經存在session內）
		if(session.getAttribute("account") != null) {
			return new AtmResponse(null, RtnCode.SUCCESSFUL);
		}
		
		// 如果session內沒有存在相同帳號密碼，則設置進session，並回傳給Impl執行
		AtmResponse res = atmService.login(req.getAccount(), req.getPwd());
		if(res.getRtnCode().getCode() == 200) {
			session.setAttribute("account", req.getAccount());
			session.setAttribute("pwd", req.getPwd());
			// set the session active time (seconds)
			session.setMaxInactiveInterval(300); // default is 30mins(1800s), 0 or negative second stands for never timeout
		}
		return res;
	}
	
	
	
	/* session for logout */
//	@CacheEvict(cacheNames = "atm_login", key = "#req.account") // 使cache失效
//	public AtmResponse logout(@RequestBody AtmRequest req, HttpSession session) {
	@GetMapping(value = "atm/logout")
	@CacheEvict(cacheNames = "atm_get_balance", key = "#req.account") // 使cache失效的url：logout?account=值
	public AtmResponse logout(@RequestParam String account, HttpSession session) {
		// 讓session失效
		session.invalidate();
		return new AtmResponse(null, RtnCode.SUCCESSFUL);
	}
	
	
	
	/* session for get balance */
	@GetMapping(value = "atm/get_balance")
	public AtmResponse getBalanceByAccount(HttpSession session) {
		
		// 使用"(String)"強制轉型成字串
		// 不使用".toString"是因為假如資料為null，會報錯
		String account = (String)session.getAttribute("account"); 
		String pwd = (String)session.getAttribute("pwd");
		if(StringUtils.hasText(account)) {
			return atmService.getBalanceByAccount(account, pwd);
		}
		return new AtmResponse(null, RtnCode.PLEASE_LOGIN_FIRST);
	}

}
