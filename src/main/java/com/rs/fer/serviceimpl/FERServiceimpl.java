package com.rs.fer.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.dao.AddressRepository;
import com.rs.fer.dao.ExpenseRepository;
import com.rs.fer.dao.UserRepository;
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
import com.rs.fer.response.GetExpenseResponseVO;
import com.rs.fer.response.GetExpensesResponseVO;
import com.rs.fer.response.ExpenseReportResponseVO;
import com.rs.fer.response.GetUserResponseVO;
import com.rs.fer.response.LoginResponseVO;
import com.rs.fer.response.RegistrationResponseVO;
import com.rs.fer.response.ResetPasswordResponseVO;
import com.rs.fer.response.UpdateUserResponseVO;
import com.rs.fer.service.FERservice;
import com.rs.fer.util.FERUtil;

@Service
public class FERServiceimpl implements FERservice {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private FERUtil ferUtil;

	@Override
	public RegistrationResponseVO registration(RegistrationRequestVO regReqVO) {

		List<User> users = userRepository.findByEmail(regReqVO.getEmail());
		if (!CollectionUtils.isEmpty(users)) {
			return new RegistrationResponseVO(HttpStatus.OK, "100",
					"User is already registered with given email: " + regReqVO.getEmail(), null);
		}

		User user = ferUtil.loadUser(regReqVO);

		user = userRepository.save(user);
		if (user.getId() > 0) {
			return new RegistrationResponseVO(HttpStatus.OK, "000", "User is registered Successfully", null);
		} else {
			return new RegistrationResponseVO(HttpStatus.OK, "001", "User registration Failed", null);
		}
	}

	@Override
	public LoginResponseVO login(LoginRequestVO loginReqVO) {

		List<User> users = userRepository.findByUsernameAndPassword(loginReqVO.getUsername(), loginReqVO.getPassword());

		if (users.size() > 0) {
			return new LoginResponseVO(HttpStatus.OK, "000", "User is valid", null);
		} else
			return new LoginResponseVO(HttpStatus.OK, "001", "User is invalid", null);
	}

	@Override
	public AddExpenseResponseVO addExpense(AddExpenseRequestVO addExpReqVO) {

		Expense expense = ferUtil.loadExpense(addExpReqVO);

		expense = expenseRepository.save(expense);

		if (expense.getExpenseId() > 0) {
			return new AddExpenseResponseVO(HttpStatus.OK, "000", "Expense is added successfully", null);
		} else
			return new AddExpenseResponseVO(HttpStatus.OK, "001", "Expense add is failed", null);
	}

	@Override
	public EditExpenseResponseVO editExpense(EditExpenseRequestVO editReqVo) {

		Expense expense = ferUtil.loadExpense(editReqVo);

		expense = expenseRepository.save(expense);

		if (expense.getExpenseId() > 0) {
			return new EditExpenseResponseVO(HttpStatus.OK, "000", "Expense edited successfully ", null);

		} else
			return new EditExpenseResponseVO(HttpStatus.OK, "001", "Expense edited Failed: ", null);

	}

	@Override
	public DeleteExpenseResponseVO deleteExpense(int expenseid) {
		expenseRepository.delete(expenseid);
		Expense expense = expenseRepository.getOne(expenseid);

		if (expense == null) {
			return new DeleteExpenseResponseVO(HttpStatus.OK, "000", "Expense deleted successfully ", null);

		} else
			return new DeleteExpenseResponseVO(HttpStatus.OK, "001", "Expense deleted Failed: ", null);

	}

	@Override
	public GetExpenseResponseVO getexpense(int expenseId) {

		Expense expense = expenseRepository.getOne(expenseId);

		if (expense != null) {

			return new GetExpenseResponseVO(HttpStatus.OK, "000", "", null, expense);
		} else {

			return new GetExpenseResponseVO(HttpStatus.OK, "001", "No expense founf for given expenseId", null);

		}
	}

	@Override
	public GetExpensesResponseVO getexpenses(int userid) {

		if (userRepository.findOne(userid) == null) {
			return new GetExpensesResponseVO(HttpStatus.OK, "000", "UserId is invalid", null);
		} else {
			List<Expense> expenses = expenseRepository.findByUserId(userid);
			if (expenses.isEmpty() || expenses == null) {
				return new GetExpensesResponseVO(HttpStatus.OK, "001", "No Expenses found", null);
			} else {

				return new GetExpensesResponseVO(HttpStatus.OK, "000", "", null);

			}
		}
	}

	@Override
	public ResetPasswordResponseVO resetPassword(ResetPasswordRequestVO resetReqVO) {

		User user = userRepository.findByIdAndPassword(resetReqVO.getUserId(), resetReqVO.getCurrentPassword());
		;
		user.setPassword(resetReqVO.getNewPassword());
		user = userRepository.save(user);

		if (user.getPassword() == resetReqVO.getNewPassword()) {
			return new ResetPasswordResponseVO(HttpStatus.OK, "000", "Password reset is successflly", null);
		} else
			return new ResetPasswordResponseVO(HttpStatus.OK, "001", "Passsword reset  is failed", null);

	}

	@Override
	public ExpenseReportResponseVO expenseReport(ExpenseReportRequestVO reportReqVO) {

		List<Expense> expenses = expenseRepository.findByUserIdAndExpenseTypeAndDateBetween(reportReqVO.getUserId(),
				reportReqVO.getExpenseType(), reportReqVO.getFromDate(), reportReqVO.getToDate());

		if (!expenses.isEmpty()) {
			return new ExpenseReportResponseVO(HttpStatus.OK, "000", "", null, expenses);

		} else
			return new ExpenseReportResponseVO(HttpStatus.OK, "001", "no expenses were found", null);

	}

	@Override
	public GetUserResponseVO getUser(int Id) {

		User user = userRepository.getOne(Id);

		if (user != null) {
			return new GetUserResponseVO(HttpStatus.OK, "000", "", null, user);
		} else
			return new GetUserResponseVO(HttpStatus.OK, "001", "no user found for given id", null);

	}

	@Override
	public UpdateUserResponseVO updateUser(UpdateUserRequestVO updateUserReqVO) {

		User user = ferUtil.loadUpdateUser(updateUserReqVO);

		user = userRepository.save(user);

		if (user.getId() > 0) {
			return new UpdateUserResponseVO(HttpStatus.OK, "000", "update user is successful", null);

		} else
			return new UpdateUserResponseVO(HttpStatus.OK, "001", "update user is failed", null);

	}

}
