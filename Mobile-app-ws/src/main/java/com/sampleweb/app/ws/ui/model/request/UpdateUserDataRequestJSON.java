package com.sampleweb.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserDataRequestJSON {
	@NotNull(message = "First Name cant be null")
	private String firstName;
	@NotNull(message = "Last Name cant be null")
	private String lastName;
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
}
