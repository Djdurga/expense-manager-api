package com.capgemini.expensetrackerapi.controller;

import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.expensetrackerapi.entity.AuthModel;
import com.capgemini.expensetrackerapi.entity.User;
import com.capgemini.expensetrackerapi.entity.UserModel;
import com.capgemini.expensetrackerapi.service.UserService;

@RestController
public class AuthController<LoginModel> {
	
	//@Autowired
//	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	/*
	 * @PostMapping("/login") public ResponseEntity<HttpStatus> login(@RequestBody
	 * AuthModel authModel) { Authentication authentication =
	 * authenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(authModel.getEmail(),
	 * authModel.getPassword()));
	 * 
	 * SecurityContextHolder.getContext().setAuthentication(authentication); return
	 * new ResponseEntity<HttpStatus>(HttpStatus.OK); }
	 */
	
	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
}

