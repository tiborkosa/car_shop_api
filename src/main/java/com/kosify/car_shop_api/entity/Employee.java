package com.kosify.car_shop_api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "employees", 
		uniqueConstraints=
			@UniqueConstraint(columnNames = {"emp_id"})) 
public class Employee extends User implements Serializable {

	private static final long serialVersionUID = -6938004461750563701L;

	private String role = "ROLE_USER";

	// for now we are manually adding this
	//TODO: create an interface to create id of preference and is unique
	@Column(name = "emp_id")
	private int empId;

	@Column(nullable = false)
	private Date dob;

	@Column(name = "hire_date", nullable = false)
	private Date hireDate;

	@Column(name = "term_date", nullable = true)
	private Date termDate;

	private char active = '+';

	@Column(name = "pwd", nullable = false)
	private String password;

	public Employee() {
	}

	public Employee(String role, int empId, Date dob, Date hireDate, Date termDate, char active, String password) {
		this.role = role;
		this.empId = empId;
		this.dob = dob;
		this.hireDate = hireDate;
		this.termDate = termDate;
		this.active = active;
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getTermDate() {
		return termDate;
	}

	public void setTermDate(Date termDate) {
		this.termDate = termDate;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
