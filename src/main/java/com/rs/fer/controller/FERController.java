package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.request.AddExpenseRequestVO;
import com.rs.fer.request.EditExpenseRequestVO;
import com.rs.fer.request.ExpenseReportRequestVO;
import com.rs.fer.request.LoginRequestVO;
import com.rs.fer.request.RegistrationRequestVO;
import com.rs.fer.request.ResetPasswordRequestVO;
import com.rs.fer.request.UpdateUserRequestVO;
import com.rs.fer.response.AddExpenseResponseVO;
import com.rs.fer.response.DeleteExpenseResponseVO;
import com.rs.fer.response.EditExpenseResponseVO;
import com.rs.fer.response.ExpenseReportResponseVO;
import com.rs.fer.response.GetExpenseResponseVO;
import com.rs.fer.response.GetExpensesResponseVO;
import com.rs.fer.response.GetUserResponseVO;
import com.rs.fer.response.LoginResponseVO;
import com.rs.fer.response.RegistrationResponseVO;
import com.rs.fer.response.ResetPasswordResponseVO;
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

	@PostMapping("/expense")
	public AddExpenseResponseVO addExpense(@ModelAttribute AddExpenseRequestVO addExpReqVO) {

		Set<String> errorMessages = ferValidation.validateAddExpenseRequest(addExpReqVO);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddExpenseResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else
			return ferService.addExpense(addExpReqVO);
	}

	@PutMapping("/resetPassword")
	public ResetPasswordResponseVO resetPassword(@ModelAttribute ResetPasswordRequestVO resetReqVO) {

		Set<String> errorMessages = ferValidation.validateResetPasswordRequest(resetReqVO);

		if (!CollectionUtils.isEmpty(errorMessages)) {

			return new ResetPasswordResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else
			return ferService.resetPassword(resetReqVO);
	}

	@GetMapping("/expense/{id}")
	public GetExpenseResponseVO getexpense(@PathVariable("id") int expenseId) {

		Set<String> errorMessages = ferValidation.validateGetExpense(expenseId);

		if (!CollectionUtils.isEmpty(errorMessages)) {

			return new GetExpenseResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else
			return ferService.getexpense(expenseId);
	}

	@GetMapping("/expenses/{userid}")
	public GetExpensesResponseVO getexpenses(@PathVariable("userid") int userId) {

		Set<String> errorMessages = ferValidation.validateGetExpenses(userId);

		if (!CollectionUtils.isEmpty(errorMessages)) {

			return new GetExpensesResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else
			return ferService.getexpenses(userId);
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

	@PutMapping("/updateUser")
	public UpdateUserResponseVO updateUser(@ModelAttribute UpdateUserRequestVO updateUserReqVO) {

		Set<String> errorMessages = ferValidation.validateUpdateUser(updateUserReqVO);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new UpdateUserResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);

		} else
			return ferService.updateUser(updateUserReqVO);

	}

	@PutMapping("/expense")
	public EditExpenseResponseVO editExpense(@ModelAttribute EditExpenseRequestVO editReqVo) {

		Set<String> errorMessages = ferValidation.validateEditExpenseRequest(editReqVo);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new EditExpenseResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else
			return ferService.editExpense(editReqVo);

	}

	@DeleteMapping("/deleteExpense/{id}")
	public DeleteExpenseResponseVO deleteExpense(@PathVariable("id") int expenseid) {

		Set<String> errorMessages = ferValidation.validateDeleteExpense(expenseid);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteExpenseResponseVO(HttpStatus.PRECONDITION_REQUIRED, "999", "", errorMessages);
		} else
			return ferService.deleteExpense(expenseid);

	}

}
