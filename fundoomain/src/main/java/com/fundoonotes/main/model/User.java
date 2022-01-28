package com.fundoonotes.main.model;

import com.fundoonotes.main.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
	private String mobileNumber;
	private String password;

	public User(UserDTO userDTO) {
		this.mobileNumber = userDTO.getMobileNumber();
		this.password = userDTO.getPassword();
	}
}
