package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.request.ExpenseReportRequestVO;
import com.rs.fer.request.LoginRequestVO;
import com.rs.fer.request.RegistrationRequestVO;
import com.rs.fer.request.UpdateUserRequestVO;
import com.rs.fer.response.ExpenseReportResponseVO;
import com.rs.fer.response.GetUserResponseVO;
import com.rs.fer.response.LoginResponseVO;
import com.rs.fer.response.RegistrationResponseVO;
import com.rs.fer.response.UpdateUserResponseVO;
import com.rs.fer.service.FERservice;
import com.rs.fer.util.validation.FERValidation;

@RestController
@RequestMapping("/fer")
public class FERController {
	
	
	
	
	

	@Autowired
	private FERservice ferService;

	@Autowired
	private FERValidation ferValidation;

	@PostMapping("/registration")
	public RegistrationResponseVO registration(@ModelAttribute RegistrationRequestVO regReqVO) {

		Set<String> errorMessages = ferValidation.validateRegistrationRequest(regReqVO);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new RegistrationResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else {
			return ferService.registration(regReqVO);
		}

	}

	@GetMapping("/login")
	public LoginResponseVO login(@ModelAttribute LoginRequestVO loginReqVO) {

		Set<String> errorMessages = ferValidation.validateLoginRequest(loginReqVO);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new LoginResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else
			return ferService.login(loginReqVO);
	}

	@GetMapping("/expenseReport/{userid}")
	public ExpenseReportResponseVO expenseReport(@ModelAttribute ExpenseReportRequestVO reportReqVO) {

		Set<String> errorMessages = ferValidation.validateExpenseReport(reportReqVO);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new ExpenseReportResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else
			return ferService.expenseReport(reportReqVO);
	}

	@GetMapping("/user/{id}")
	public GetUserResponseVO getUser(@PathVariable("id") int id) {

		Set<String> errorMessages = ferValidation.validateGetUser(id);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetUserResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else
			return ferService.getUser(id);
	}

	@GetMapping("/updateUser")
	public UpdateUserResponseVO updateUser(@ModelAttribute UpdateUserRequestVO updateUserReqVO) {

		Set<String> errorMessages = ferValidation.validateUpdateUser(updateUserReqVO);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new UpdateUserResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else 
			return ferService.updateUser(updateUserReqVO);
	}

}
