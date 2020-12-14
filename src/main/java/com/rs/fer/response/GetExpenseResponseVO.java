package com.rs.fer.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.bean.Expense;

public class GetExpenseResponseVO extends AbstractResponse {

	private Expense expense;
	
	 public GetExpenseResponseVO(HttpStatus status, String errorCode, String message, Set<String> errorMessages) {
		super(status, errorCode, message, errorMessages);
	
	}

	 public GetExpenseResponseVO(HttpStatus status, String errorCode, String message, Set<String> errorMessages,
			 Expense expense) {
		 super(status, errorCode, message, errorMessages);
		this.expense=expense;
	}
	 public Expense getExpense() {
		 return expense;
	 }
     public void setExpense(Expense expense) {
    	this.expense=expense;
     }

}
