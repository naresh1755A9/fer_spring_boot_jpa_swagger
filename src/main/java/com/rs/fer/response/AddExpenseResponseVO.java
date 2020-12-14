package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

public class AddExpenseResponseVO extends AbstractResponse {

	public AddExpenseResponseVO(HttpStatus status, String errorCode, String message, Set<String> errorMessages) {
		super(status, errorCode, message, errorMessages);
	}
}
