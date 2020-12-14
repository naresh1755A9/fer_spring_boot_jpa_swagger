package com.rs.fer.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id", length=10)
	private int id;
	
	@Column(name="firstname", length=20)
	private String firstname;
	@Column(name="middlename", length=20)
	private String middlename;
	@Column(name="lastname", length=20)
	private String lastname;
	@Column(name="email", length=20)
	private String email;
	@Column(name="mobile", length=10)
	private String mobile;
	@Column(name="username", length=20)
	private String username;
	@Column(name="password", length=20)
	private String password;
	
	@Column(name = "created" , length=10)
	private String created;
	@Column(name = "updated" , length=10)
	private String updated;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Expense.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName ="id")
	//user_id is FK in Expense & id is PK in User
	private Set<Expense> expenses;
	
	//@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "addressid", referencedColumnName ="addressId")
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Address address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Expense> getExpenses() {
		return expenses;
	}
	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
