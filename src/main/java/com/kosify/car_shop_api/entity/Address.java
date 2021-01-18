package com.kosify.car_shop_api.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {

	private static final long serialVersionUID = 4264645022438902008L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name= "address_id")
	private UUID addressId;
	
	@Column(nullable = false, length = 50)
	private String country;
	
	@Column( nullable = false, length = 50)
	private String state;
	
	@Column( nullable = false, length = 50)
	private String city;
	
	@Column( nullable = false, length = 255)
	private String street;
	
	@Column(name = "street_number", nullable = false, length = 50)
	private String streetNumber;
	
	@Column( nullable = false, length = 10)
	private String zip;
	
	public Address() {}

	public Address(String country, String state, String city, String street, String streetNumber, String zip) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.zip = zip;
	}
	
	public UUID getAddressId() {
		return addressId;
	}
	public void setAddressId(UUID addressId) {
		this.addressId = addressId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
