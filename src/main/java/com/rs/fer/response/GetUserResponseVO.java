package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.bean.User;

public class GetUserResponseVO extends AbstractResponse{
	
	private User user;

	public GetUserResponseVO(HttpStatus status, String errorCode, String message, Set<String> errorMessages) {
		super(status, errorCode, message, errorMessages);
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public GetUserResponseVO(HttpStatus status, String errorCode, String message, Set<String> errorMessages,User user) {
		super(status, errorCode, message, errorMessages);
		this.user=user;
		
	}

}
