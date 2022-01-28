package com.fundoonotes.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.fundoonotes.main.dto.PropertyBean;
import com.fundoonotes.main.dto.ResponseDTO;
import com.fundoonotes.main.exception.FundooMainException;
import com.fundoonotes.main.model.Note;
import com.fundoonotes.main.model.User;
import com.fundoonotes.main.utility.JwtTokenUtil;

public class FundooMainController {
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Autowired
	private PropertyBean propertyBean;

	@PostMapping("/signup")
	public ResponseEntity<ResponseDTO> userSignUp(@RequestBody User user) {
		User signUpUser = new RestTemplate().postForObject(propertyBean.getSignupURL(), user, User.class);
		if (signUpUser.getMobileNumber() == null) {
			throw new FundooMainException("User Number Already Registered");
		} else {
			ResponseDTO responseDTO = new ResponseDTO("User Created", user, HttpStatus.OK);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
	}

	@GetMapping("/login")
	public ResponseEntity<ResponseDTO> userLogin(@RequestBody User user) {
		String loginUser = new RestTemplate().postForObject(propertyBean.getLoginURL(), user, String.class);
		if (loginUser == null) {
			throw new FundooMainException("User not Registered");
		} else {
			ResponseDTO responseDTO = new ResponseDTO("Token Genrated", loginUser, HttpStatus.OK);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("deletebyid/{id}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") Long id) {
		new RestTemplate().delete(propertyBean.getDeleteUserByIdURL(), id);
		ResponseDTO responseDTO = new ResponseDTO("User Deleted Successfully", HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/getallbooks")
	public ResponseEntity<ResponseDTO> withoutLogin() {
		ResponseEntity<Note[]> personList = new RestTemplate().getForEntity(propertyBean.getGetallNoteURL(),
				Note[].class);
		ResponseDTO responseDTO = new ResponseDTO("Books", personList.getBody(), HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
