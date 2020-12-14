
package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

public class AbstractResponse {

	private HttpStatus status;
	private String errorCode;
	private String message;
	private Set<String> errorMessages;

	public AbstractResponse(HttpStatus status, String errorCode, String message, Set<String> errorMessages) {
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Set<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(Set<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

}
