package com.rs.fer.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.bean.Expense;

public class GetExpensesResponseVO extends AbstractResponse {

	
	
	 public GetExpensesResponseVO(HttpStatus status, String errorCode, String message, Set<String> errorMessages) {
		super(status, errorCode, message, errorMessages);
	
	}

	public void setExpenses(List<Expense> expenses) {
		// TODO Auto-generated method stub
		
	}



}
