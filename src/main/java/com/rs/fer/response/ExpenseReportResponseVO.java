package com.rs.fer.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.bean.Expense;

public class ExpenseReportResponseVO extends AbstractResponse {
	
	private List<Expense> expenses;

	public ExpenseReportResponseVO(HttpStatus status, String errorCode, String message, Set<String> errorMessages) {
		super(status, errorCode, message, errorMessages);

	}
	
	public ExpenseReportResponseVO(HttpStatus status, String errorCode, String message, Set<String> errorMessages,List<Expense> expenses) {
		super(status, errorCode, message, errorMessages);
		this.expenses=expenses;

	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expense) {
		this.expenses = expense;
	}

}
