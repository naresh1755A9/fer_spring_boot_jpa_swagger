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
	public ExpenseReportResponseVO expenseReport(ExpenseReportRequestVO reportReqVO) {

		List<Expense> expenses = expenseRepository.findByUserIdAndExpenseTypeAndDateBetween(reportReqVO.getUserId(),
				reportReqVO.getExpenseType(), reportReqVO.getFromDate(), reportReqVO.getToDate());

		if (!expenses.isEmpty()) {
			return new ExpenseReportResponseVO(HttpStatus.OK, "000", "", null);
		} else
			return new ExpenseReportResponseVO(HttpStatus.OK, "001", "No Expenses Were Found", null);
	}
	
	@Override
	public GetUserResponseVO getUser(int Id) {

		User user = userRepository.getOne(Id);

		if (user != null) {
			return new GetUserResponseVO(HttpStatus.OK, "000", "", null);
		} else
			return new GetUserResponseVO(HttpStatus.OK, "001", "No User Found For Given Id", null);
	}

	@Override
	public UpdateUserResponseVO updateUser(UpdateUserRequestVO updateUserReqVO) {

		User user = ferUtil.loadUpdateUser(updateUserReqVO);

		user = userRepository.save(user);

		if (user.getId() > 0) {
			return new UpdateUserResponseVO(HttpStatus.OK, "000", "Update User Is Successfull", null);
		} else
			return new UpdateUserResponseVO(HttpStatus.OK, "001", "Update User Is Failed", null);
	}

}
