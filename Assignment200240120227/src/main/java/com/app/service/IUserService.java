package com.app.service;

import com.app.pojos.User;

public interface IUserService {
	
	public String saveUser(User u);
	
	public User validateUser(String email);

}
