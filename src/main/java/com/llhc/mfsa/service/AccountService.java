package com.llhc.mfsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.AccountDao;
import com.llhc.mfsa.entity.UserInfo;

@Service
public class AccountService {

	@Autowired
	private AccountDao dao;
	
	public UserInfo confirm(UserInfo account) {
		return dao.selectUser(account);
	}
	
}
