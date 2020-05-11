package com.projects.app.users.view.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 551803454205416480L;

	private String userID;

	@NotNull(message="firstName is required")
	@Size(min=2, max=50, message="firstName cannot be less than 2 characters and more than 50")
	private String firstName;

	@NotNull(message="lastName is required")
	@Size(min=2, max=50, message="lastName cannot be less than 2 characters and more than 50")
	private String lastName;

	@NotNull(message="password is required")
	@Size(min=8, max=16, message="password cannot be less than 8 characters and more than 16")
	private String password;
	
	@NotNull(message="email is required")
	@Email
	private String email;


	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
