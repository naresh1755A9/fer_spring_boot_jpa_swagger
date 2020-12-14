package com.rs.fer.util;

import com.rs.fer.bean.User;
import com.rs.fer.request.RegistrationRequestVO;

public interface FERUtil {

	User loadUser(RegistrationRequestVO regReqVO);

}
