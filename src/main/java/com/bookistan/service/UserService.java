package com.bookistan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookistan.entity.User;
import com.bookistan.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;

	public void saveUser(User user) {
		ur.save(user);
	}
	
}
