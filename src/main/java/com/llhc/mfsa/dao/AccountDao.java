package com.llhc.mfsa.dao;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.UserInfo;

@Component
public interface AccountDao {

	public UserInfo selectUser(UserInfo user);
	
}
