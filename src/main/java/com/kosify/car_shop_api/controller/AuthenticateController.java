package com.kosify.car_shop_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosify.car_shop_api.config.jwt.JwtProvider;
import com.kosify.car_shop_api.entity.Employee;
import com.kosify.car_shop_api.model.auth.AuthRequest;
import com.kosify.car_shop_api.model.auth.AuthResponse;
import com.kosify.car_shop_api.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class AuthenticateController {

	@Autowired
	EmployeeService employeeService;
	
	 @Autowired
	 private JwtProvider jwtProvider;
	 
	 @PostMapping("auth")
	public AuthResponse auth(@RequestBody @Validated AuthRequest request) {
		String token = "";
		Employee emp = employeeService.findByLoginAndPassword(
				Integer.parseInt(request.getId()), 
				request.getPswd());
		if(emp != null) {
			token = jwtProvider.generateToken(request.getId());
		}
		
		return new AuthResponse(token);
	}
}
