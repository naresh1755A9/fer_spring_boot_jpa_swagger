package com.rs.fer.util;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.request.AddExpenseRequestVO;
import com.rs.fer.request.EditExpenseRequestVO;
import com.rs.fer.request.RegistrationRequestVO;
import com.rs.fer.request.UpdateUserRequestVO;

public interface FERUtil {
	
	User loadUser(RegistrationRequestVO regReqVO);

	Expense loadExpense(AddExpenseRequestVO addExpReqVO);
	
	User loadUpdateUser(UpdateUserRequestVO updateUserReqVO);

	Expense loadExpense(EditExpenseRequestVO editReqVo);

	
}
