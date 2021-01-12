package com.app.dao;

import com.app.pojos.User;

public interface IUserRepository {

	public String saveUser(User u);
	public User validateUser(String email);

}
