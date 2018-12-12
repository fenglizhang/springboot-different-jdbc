package com.zlf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlf.bo.User;
import com.zlf.repository.CurdUserRepository;
import com.zlf.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private CurdUserRepository userRepo;
	
	@Override
	public User findOne(String id) {

		userRepo.findOne(id);
		return null;
	}

}
