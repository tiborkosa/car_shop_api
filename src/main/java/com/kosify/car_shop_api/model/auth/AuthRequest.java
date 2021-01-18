package com.kosify.car_shop_api.model.auth;

import org.springframework.lang.NonNull;

public class AuthRequest {

	@NonNull
	private String id;
	@NonNull
	private String pswd;
	
	public AuthRequest() {}
	
	public AuthRequest(String id, String pswd) {
		super();
		this.id = id;
		this.pswd = pswd;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
}
