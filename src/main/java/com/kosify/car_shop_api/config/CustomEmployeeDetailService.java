package com.kosify.car_shop_api.config;

import com.kosify.car_shop_api.entity.Employee;
import com.kosify.car_shop_api.exception.ResourceNotFoundException;
import com.kosify.car_shop_api.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomEmployeeDetailService implements UserDetailsService {
    @Autowired
    private EmployeeService employeeService;

	@Override
	public CustomEmployeeDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		 Employee emp = employeeService.findByEmpId(Integer.valueOf(id));
		try {
			return CustomEmployeeDetails.fromEmployeeToCustomEmployeeDetails(emp);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}