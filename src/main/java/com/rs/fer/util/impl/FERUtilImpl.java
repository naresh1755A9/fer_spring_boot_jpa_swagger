package com.rs.fer.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.bean.User;
import com.rs.fer.request.RegistrationRequestVO;
import com.rs.fer.util.FERUtil;

@Component
public class FERUtilImpl implements FERUtil {

	@Override
	public User loadUser(RegistrationRequestVO regReqVO) {

		User user = new User();
		user.setFirstname(regReqVO.getFirstname());
		user.setMiddlename(regReqVO.getMiddlename());
		user.setLastname(regReqVO.getLastname());
		user.setEmail(regReqVO.getEmail());
		user.setUsername(regReqVO.getUsername());
		user.setPassword(regReqVO.getPassword());
		user.setMobile(regReqVO.getMobile());

		user.setCreated(DateUtil.getCurrentDate());

		return user;
	}

}