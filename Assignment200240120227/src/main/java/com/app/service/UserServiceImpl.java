package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserRepository;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository repo;
	
	public UserServiceImpl() {
		System.out.println("In default constructor : " + getClass().getName());
	}
	@Override
	public String saveUser(User u) {
		return repo.saveUser(u);
	}

	@Override
	public User validateUser(String email) {
		return repo.validateUser(email);
	}

}
