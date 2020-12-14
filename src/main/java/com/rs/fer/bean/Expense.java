package com.rs.fer.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Expense {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="expenseid", length=10)
	private int expenseId;
	
	@Column(name="expensetype", length=15)
	private String expenseType;
	@Column(name="date", length=10)
	private String date;
	@Column(name="price", length=10)
	private float price;
	@Column(name="numberofitems", length=10)
	private int numberOfItems;
	@Column(name="total", length=10)
	private float total;
	@Column(name="bywhom", length=15)
	private String byWhom;
	
	@Column(name="user_id", length=10)
	private int userId;


	@Column(name = "created" , length=10)
	private String created;
	@Column(name = "updated" , length=10)
	private String updated;
	
	public int getExpenseId() {
		return expenseId;
	}
	
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getByWhom() {
		return byWhom;
	}

	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
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
