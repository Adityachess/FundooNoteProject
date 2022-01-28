package com.fundoonotes.user.service;

import com.fundoonotes.user.dto.RequestDto;
import com.fundoonotes.user.model.User;

public interface IUserService {
	
	User updateUser(Long id, RequestDto requestDto);
	void deletebyID(Long id);
	/**
	 * implementing method generatingToken
	 */
	String generateToken(User user);
	User createUser(User user);

}
