package com.rs.fer.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address {

	@Id
	@Column(name="addressid", length=10)
	private int addressId;

	@Column(name="lineone", length=30)
	private String lineOne;
	@Column(name="linetwo", length=30)
	private String lineTwo;
	@Column(name="city", length=20)
	private String city;
	@Column(name="state", length=20)
	private String state;
	@Column(name="country", length=20)
	private String country;
	@Column(name="pincode", length=10)
	private String pincode;
	@Column(name="userid", length=10)
	private int userId;

	@OneToOne
    @MapsId
    @JoinColumn(name = "addressid")
    private User user;
	
	
	@Column(name = "created" , length=10)
	private String created;
	@Column(name = "updated" , length=10)
	private String updated;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getAddressId() {
		return addressId;
	}
	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getLineOne() {
		return lineOne;
	}

	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	public String getLineTwo() {
		return lineTwo;
	}

	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
