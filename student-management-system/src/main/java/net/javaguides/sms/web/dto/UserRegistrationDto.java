package net.javaguides.sms.web.dto;

import javax.validation.constraints.*;

public class UserRegistrationDto {
	
	@NotNull(message = "first name empty")
	private String firstName;
	
	@NotNull(message = "last name empty")
	private String lastName;
	
	@NotNull(message = "email empty")
	private String email;
	
	@NotNull(message = "password empty")
	private String password;

	public UserRegistrationDto(){

	}

	public UserRegistrationDto(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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
}