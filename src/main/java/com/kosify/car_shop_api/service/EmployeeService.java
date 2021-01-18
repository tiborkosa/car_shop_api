package com.kosify.car_shop_api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosify.car_shop_api.entity.Employee;
import com.kosify.car_shop_api.exception.ResourceNotFoundException;
import com.kosify.car_shop_api.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Employee saveUser(Employee employee) {
		String enc_pass = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(enc_pass);
		
		return employeeRepository.save(employee);
	}
	
	public Employee findByEmpId(int id) {
		return employeeRepository.findByEmpId(id);
	}
	
	public Employee findByLoginAndPassword(int id, String pswd) {
		Employee emp = findByEmpId(id);
		
		if(null != emp) {
			if(passwordEncoder.matches(pswd, emp.getPassword())){
				return emp;
			}
		}
		
		return null;
	}

	public Employee findById(UUID id) throws ResourceNotFoundException {
		return employeeRepository
				.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("Employee was not found with id:: " +id ));
	}

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public String deleteEmployee(UUID id) throws ResourceNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(id) ;
		if(employee.isPresent()) {
			employeeRepository.delete(employee.get());
			return "User was deleted!";
		} else {
			throw new ResourceNotFoundException("[Delete] Could not find employee with id: " + id);
		}
	}
}
