package com.rs.fer.request;

public class EditExpenseRequestVO {
	
	private String expensetype;
	private String date;
	private float price;
	private int numberofitems;
	private float total;
	private String bywhom;
	
	public String getExpensetype() {
		return expensetype;
	}
	public void setExpensetype(String expensetype) {
		this.expensetype = expensetype;
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
	public int getNumberofitems() {
		return numberofitems;
	}
	public void setNumberofitems(int numberofitems) {
		this.numberofitems = numberofitems;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getBywhom() {
		return bywhom;
	}
	public void setBywhom(String bywhom) {
		this.bywhom = bywhom;
	}
	public int getExpenseid() {
		return expenseid;
	}
	public void setExpenseid(int expenseid) {
		this.expenseid = expenseid;
	}
	private int expenseid;
	
}