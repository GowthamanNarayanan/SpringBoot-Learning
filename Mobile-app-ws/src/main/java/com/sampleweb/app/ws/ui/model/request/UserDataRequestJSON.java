package com.sampleweb.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDataRequestJSON {
	@NotNull(message = "First Name cant be null")
	private String firstName;
	@NotNull(message = "Last Name cant be null")
	private String lastName;
	@NotNull(message = "Email cant be null")
	@Email
	private String email;
	@NotNull(message = "Password cant be null")
	@Size(min = 6, max = 8, message = "Password should be equal or greater than 6 characters and lesser than 9 characters")
	private String password;
	private String userID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	
}
