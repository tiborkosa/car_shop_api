package com.kosify.car_shop_api.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kosify.car_shop_api.entity.Employee;
import com.kosify.car_shop_api.exception.ResourceNotFoundException;

public class CustomEmployeeDetails implements UserDetails{
	private static final long serialVersionUID = -6476593413017775263L;
	
	private String empId;
	private String pwd;
	private Collection<? extends GrantedAuthority> grantedAuthority;
	
	public static CustomEmployeeDetails fromEmployeeToCustomEmployeeDetails(Employee emp) throws ResourceNotFoundException {
		
		if(null == emp) {
			throw new ResourceNotFoundException("Employee was not found!");
		}
		CustomEmployeeDetails c = new CustomEmployeeDetails();
		c.empId = String.valueOf(emp.getEmpId());
		c.pwd = emp.getPassword();
		c.grantedAuthority = Collections.singleton(new SimpleGrantedAuthority(emp.getRole()));
		return c;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthority;
	}
	@Override
	public String getPassword() {
		return pwd;
	}
	@Override
	public String getUsername() {
		return empId;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
