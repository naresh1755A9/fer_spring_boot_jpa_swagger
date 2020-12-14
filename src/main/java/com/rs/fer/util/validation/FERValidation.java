package com.rs.fer.util.validation;

import java.util.Set;

import com.rs.fer.request.LoginRequestVO;
import com.rs.fer.request.RegistrationRequestVO;

public interface FERValidation {

	Set<String> validateRegistrationRequest(RegistrationRequestVO registrationRequestVO);

	Set<String> validateLoginRequest(LoginRequestVO loginReqVO);

}
