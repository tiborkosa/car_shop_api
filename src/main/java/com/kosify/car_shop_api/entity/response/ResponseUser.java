package com.kosify.car_shop_api.entity.response;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.kosify.car_shop_api.entity.Address;

public class ResponseUser {

	private UUID userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date createAt;
	private Set<Address> address = new HashSet<>();

	public ResponseUser() {
	}

	public ResponseUser(UUID userId, String firstName, String lastName, String email, String phoneNumber, Date createAt,
			Set<Address> address) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.createAt = createAt;
		this.address = address;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

}
