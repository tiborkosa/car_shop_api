package com.kosify.car_shop_api.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cars")
public class Car implements Serializable {
	private static final long serialVersionUID = 8801246898052520420L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private User owner;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(nullable = false)
	private String make;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private String vin;
	
	public Car(User owner, Integer year, String make, String model, String vin) {
		super();
		this.owner = owner;
		this.year = year;
		this.make = make;
		this.model = model;
		this.vin = vin;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	
}
