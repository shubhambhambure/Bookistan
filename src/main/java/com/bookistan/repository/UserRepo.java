package com.bookistan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookistan.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUserId(String userId);
	User findByPassword(String password);
	User findByUserIdAndPassword(String userId, String Password);

}
