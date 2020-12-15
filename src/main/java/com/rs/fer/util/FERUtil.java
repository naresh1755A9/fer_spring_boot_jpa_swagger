package com.rs.fer.util;

import com.rs.fer.bean.User;
import com.rs.fer.request.RegistrationRequestVO;
import com.rs.fer.request.UpdateUserRequestVO;

public interface FERUtil {

	User loadUser(RegistrationRequestVO regReqVO);
	
	User loadUpdateUser(UpdateUserRequestVO updateUserReqVO);
}
