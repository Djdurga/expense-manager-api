package com.capgemini.expensetrackerapi.service;

import com.capgemini.expensetrackerapi.entity.User;
import com.capgemini.expensetrackerapi.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel user);
	
	User readUser(Long id);

	User updateUser(UserModel user, Long id);
	
	void deleteUser(Long id);
	
	//User getLoggedInUser();
}
