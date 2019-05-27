/**
 * 
 */
package com.hht.api.feeder.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.modelmapper.ModelMapper;

import com.hht.api.feeder.constants.ValidationPattern;
import com.hht.api.feeder.model.User;

/**
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */
public class UserDto implements Serializable{

	private static final long serialVersionUID = -4884562810319398264L;

	@NotBlank(message="username cannot be null or empty")
	private transient String username;
	
	@NotBlank(message="password cannot be null or empty")
	private transient String password;
	
	@Pattern(regexp = ValidationPattern.EMAIL_PATTERN, message="Invalid email format")
	private transient String email;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", email=" + email + "]";
	}

	public User convertToUser() {
		
		ModelMapper model = new ModelMapper();
		User user = model.map(this, User.class);
		return user;
	}
}
