package com.rs.fer.service;

import com.rs.fer.request.LoginRequestVO;
import com.rs.fer.request.RegistrationRequestVO;
import com.rs.fer.response.LoginResponseVO;
import com.rs.fer.response.RegistrationResponseVO;

public interface FERservice {

	RegistrationResponseVO registration(RegistrationRequestVO regReqVO);

	LoginResponseVO login(LoginRequestVO loginReqVo);

}
