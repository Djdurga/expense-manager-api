package com.capgemini.expensetrackerapi.service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capgemini.expensetrackerapi.entity.User;
import com.capgemini.expensetrackerapi.entity.UserModel;
import com.capgemini.expensetrackerapi.entity.repository.UserRepository;
import com.capgemini.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import com.capgemini.expensetrackerapi.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(UserModel user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistsException("User is already register with email:"+user.getEmail());
		}
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		return userRepository.save(newUser);
	}

	@Override
	public User readUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for the id:" +id));
	}

	@Override
	public User updateUser(UserModel user, Long id) {
		User existingUser = readUser(id);
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
		existingUser.setPassword(user.getPassword() != null ? user.getPassword() : existingUser.getPassword());
		existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) {
	   User existingUser = readUser(id);
	   userRepository.delete(existingUser);
		
	}

	/*
	 * @Override public User getLoggedInUser() { Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * String email = authentication.getName();
	 * 
	 * return userRepository.findByEmail(email).orElseThrow(() -> new
	 * UsernameNotFoundException("User not found for the email"+email)); }
	 */
}

