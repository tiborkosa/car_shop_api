package com.kosify.car_shop_api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosify.car_shop_api.entity.Employee;
import com.kosify.car_shop_api.exception.ResourceNotFoundException;
import com.kosify.car_shop_api.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("employee/{id}")
	public Employee getEmployee(@PathVariable(value= "id") UUID id) throws ResourceNotFoundException {
		return employeeService.findById(id);
	}
	
	@GetMapping("employee")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@PostMapping("employee")
	public Employee createNewEmployee(@RequestBody Employee employee) {
		return employeeService.saveUser(employee);
	}
	
	@PutMapping("employee")
	public Employee updateEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
		// avoiding to create new employee
		if(null == employee.getUserId())
			throw new ResourceNotFoundException("Cannot update an employee without an id!");
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("employee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
		return employeeService.deleteEmployee(id);
	}
}
