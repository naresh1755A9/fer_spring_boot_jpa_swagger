package com.rs.fer.util.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rs.fer.request.AddExpenseRequestVO;
import com.rs.fer.request.EditExpenseRequestVO;
import com.rs.fer.request.ExpenseReportRequestVO;
import com.rs.fer.request.LoginRequestVO;
import com.rs.fer.request.RegistrationRequestVO;
import com.rs.fer.request.ResetPasswordRequestVO;
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
	public Set<String> validateAddExpenseRequest(AddExpenseRequestVO addExpVO) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, addExpVO.getExpenseType(), "Please enter first name");
		errorMessages = validateProperty(errorMessages, addExpVO.getDate(), "Please enter last name");
		errorMessages = validateProperty(errorMessages, addExpVO.getPrice(), "Please enter email");
		errorMessages = validateProperty(errorMessages, addExpVO.getTotal(), "Please enter username");
		errorMessages = validateProperty(errorMessages, addExpVO.getNumberOfItems(), "Please enter number of items");
		errorMessages = validateProperty(errorMessages, addExpVO.getByWhom(), "Please enter by whom");
		errorMessages = validateProperty(errorMessages, addExpVO.getUserId(), "Please enter user id");

		return errorMessages;
	}

	@Override
	public Set<String> validateExpenseReport(ExpenseReportRequestVO reportReqVO) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, reportReqVO.getUserId(), "Please enter userId");
		errorMessages = validateProperty(errorMessages, reportReqVO.getExpenseType(), "Please enter expenseType");
		errorMessages = validateProperty(errorMessages, reportReqVO.getFromDate(), "Please enter fromdate");
		errorMessages = validateProperty(errorMessages, reportReqVO.getToDate(), "Please enter to date");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetUser(int Id) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, Id, "Please enter Id ");

		return errorMessages;
	}

	@Override
	public Set<String> validateUpdateUser(UpdateUserRequestVO updateUserReqVO) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, updateUserReqVO.getFirstname(), "Please enter firstname");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getLastname(), "Please enter lastname");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getEmail(), "Please enter email");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getMobile(), "Please enter mobile");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getUsername(), "Please enter username");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getPassword(), "Please enter password");

		errorMessages = validateProperty(errorMessages, updateUserReqVO.getLine1(), "Please enter line1");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getLine2(), "Please enter line2");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getCity(), "Please enter city");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getState(), "Please enter state");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getPostal(), "Please enter postal");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getCountry(), "Please enter country");
		errorMessages = validateProperty(errorMessages, updateUserReqVO.getUserId(), "Please enter userId");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetExpense(int ExpenseId) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, ExpenseId, " Please enter ExpenseId ");
		return errorMessages;
	}

	@Override
	public Set<String> validateGetExpenses(int userId) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, userId, "Please enter UserId ");
		return errorMessages;
	}

	@Override
	public Set<String> validateResetPasswordRequest(ResetPasswordRequestVO resetReqestVO) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, resetReqestVO.getUserId(), "please enter UserId");
		errorMessages = validateProperty(errorMessages, resetReqestVO.getCurrentPassword(),
				"please enter CurrentPassword");
		errorMessages = validateProperty(errorMessages, resetReqestVO.getNewPassword(), "please enter NewPassword");

		return errorMessages;
	}

	@Override
	public Set<String> validateEditExpenseRequest(EditExpenseRequestVO editReqVo) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, editReqVo.getExpensetype(), "Please enter first name");
		errorMessages = validateProperty(errorMessages, editReqVo.getDate(), "Please enter last name");
		errorMessages = validateProperty(errorMessages, editReqVo.getPrice(), "Please enter email");
		errorMessages = validateProperty(errorMessages, editReqVo.getTotal(), "Please enter username");
		errorMessages = validateProperty(errorMessages, editReqVo.getNumberofitems(), "Please enter number of items");
		errorMessages = validateProperty(errorMessages, editReqVo.getBywhom(), "Please enter by whom");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteExpense(int expenseid) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = validateProperty(errorMessages, expenseid, "Please enter ExpenseId");

		return errorMessages;	}
}
