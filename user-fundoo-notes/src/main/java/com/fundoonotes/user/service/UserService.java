package com.fundoonotes.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fundoonotes.user.dto.RequestDto;
import com.fundoonotes.user.exception.UserException;
import com.fundoonotes.user.model.User;
import com.fundoonotes.user.repository.UserRepository;
import com.fundoonotes.user.util.JwtTokenUtil;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
    public User createUser(User user){
        return userRepository.save(user);
    }
	/**
	 * implementing method generatingToken
	 */
	

	@Override
	public void deletebyID(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(Long id, RequestDto requestDto) {
		User user = userRepository.findById(id).get();
		user.updateUser(requestDto);
		return userRepository.save(user);

	}
	@Override
	public String generateToken(User user) {
		 Optional<User> userOptional = userRepository.getDetails(user.getMobileNumber() , user.getPassword());
	        if(userOptional.isPresent()){

	            return jwtTokenUtil.generateToken(user.getMobileNumber());
	        }
	        else{
	            throw new UserException("User Not Found");
	        }   
	}
}
