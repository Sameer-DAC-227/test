package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public class UserRepositoryImpl implements IUserRepository {

	@Autowired
	private EntityManager mgr;
	
	public UserRepositoryImpl() {
		System.out.println("In default constructor : " + getClass().getName());
	}
	@Override
	public String saveUser(User u) {
		String message = "Signup completed successfully";
		mgr.persist(u);
		return message;
	}

	@Override
	public User validateUser(String email) {
		String jpql = "select u from User u where u.email=:em";
		return mgr.createQuery(jpql,User.class).setParameter("em", email).getSingleResult();
	}

}
