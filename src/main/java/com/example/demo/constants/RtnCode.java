package com.example.demo.constants;

public enum RtnCode {
	
	
	/* 列舉：呼叫的項目(code, message)*/ // 每句後面加上"//"是為了格式刷新時前後兩句不連接
	SUCCESSFUL(200, "OK!"), //
	PARAM_ERROR(400, "Param eroor!"), //
	ACCOUNT_EXISTED(400, "Account existed!"), //
	ACCOUNT_NOT_FOUND(404, "Account not found!"), //
	INSUFFICIENT_BALANCE(400, "Insufficient balance!");
	


	/* 宣告兩項（必做） */
	private int code; // 一開始建立時會報錯，是因為上面沒有列舉
	
	private String message;

	
	/* constructor */
	// 無法建立預設建構方法，只建立建構方法即可
	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}


	/* getter */
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
}
