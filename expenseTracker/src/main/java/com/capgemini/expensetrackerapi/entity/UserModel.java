package com.capgemini.expensetrackerapi.entity;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;


@Data
public class UserModel {
	
	@NotNull(message = "Name should not be empty")
	private String name;
	
	@NotNull(message = "Email should not be empty")
	@Email(message = "Enter a valid email")
	private String email;
	
	@NotNull(message = "Password should not be empty")
	@Size(min = 5, message = "Password should be atleast 5 characters")
	private String password;
	
	private Long age = 0L;

}
