package com.rs.fer.util.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rs.fer.request.ExpenseReportRequestVO;
import com.rs.fer.request.LoginRequestVO;
import com.rs.fer.request.RegistrationRequestVO;
import com.rs.fer.request.UpdateUserRequestVO;
import com.rs.fer.util.validation.FERValidation;

@Component
public class FERValidationUtilImpl implements FERValidation {

	@Override
	public Set<String> validateRegistrationRequest(RegistrationRequestVO registrationRequestVO) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, registrationRequestVO.getFirstname(),
				"Please  enter FirstName");
		errorMessages = validateProperty(errorMessages, registrationRequestVO.getLastname(), "Please  enter LastName");
		errorMessages = validateProperty(errorMessages, registrationRequestVO.getEmail(), "Please  enter Email");
		errorMessages = validateProperty(errorMessages, registrationRequestVO.getMobile(), "Please  enter Mobile");
		errorMessages = validateProperty(errorMessages, registrationRequestVO.getUsername(), "Please  enter Username");
		errorMessages = validateProperty(errorMessages, registrationRequestVO.getPassword(), "Please  enter Password");

		return errorMessages;
	}

	public Set<String> validateProperty(Set<String> errorMessages, Object value, String errorMessage) {

		if (StringUtils.isEmpty(value)) {
			errorMessages.add(errorMessage);
		} else if ((value.getClass().equals(Integer.class) || value.getClass().equals(Float.class))
				&& Float.parseFloat(value.toString()) <= 0) {
			errorMessages.add(errorMessage);
		}
		return errorMessages;
	}

	@Override
	public Set<String> validateLoginRequest(LoginRequestVO loginReqVO) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, loginReqVO.getUsername(), "Please enter username");
		errorMessages = validateProperty(errorMessages, loginReqVO.getPassword(), "Please enter password");

		return errorMessages;
	}

	@Override
	public Set<String> validateExpenseReport(ExpenseReportRequestVO reportReqVO) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, reportReqVO.getUserId(), "Please Enter UserId");
		errorMessages = validateProperty(errorMessages, reportReqVO.getExpenseType(), "Please Enter ExpenseType");
		errorMessages = validateProperty(errorMessages, reportReqVO.getFromDate(), "Please Enter FromDate");
		errorMessages = validateProperty(errorMessages, reportReqVO.getToDate(), "Please Enter ToDate");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetUser(int Id) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, Id, "Please Enter Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateUpdateUser(UpdateUserRequestVO updateUserReqVO) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, updateUserReqVO.getFirstname(), "Please Enter FirstName");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getLastname(), "Please Enter LastName");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getEmail(), "Please Enter Email");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getMobile(), "Please Enter Mobile");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getUsername(), "Please Enter UserName");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getPassword(), "Please Enter Password");

		errorMessages = validateProperty(errorMessages, updateUserReqVO.getLine1(), "Please Enter Line1");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getLine2(), "Please Enter Line2");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getCity(), "Please Enter City");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getState(), "Please Enter State");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getPincode(), "Please Enter PinCode");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getCountry(), "Please Enter Country");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getUserId(), "Please Enter UserId");

		return errorMessages;
	}

}
