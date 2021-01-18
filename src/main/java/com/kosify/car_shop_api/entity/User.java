package com.kosify.car_shop_api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

	private static final long serialVersionUID = -6188952551163094655L;

	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name= "id")
	private UUID userId;
	
	@Column( name= "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column( name= "last_name", nullable = false, length = 50)
	private String lastName;
	
	@Column( name= "email", nullable = false, length = 100)
	private String email;
	
	@Column( name= "phone", length = 15)
	private String phoneNumber;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createAt;
	
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="adrs_fk", referencedColumnName = "id")
	private Set<Address> address = new HashSet<>();
	
	public User() {}
	
	public User(String firstName, String lastName, String email, String phoneNumber, Date createAt,
			Set<Address> address) {
		super();
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
