package com.fundoonotes.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.user.dto.RequestDto;
import com.fundoonotes.user.dto.ResponseDTO;
import com.fundoonotes.user.model.User;
import com.fundoonotes.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUser(@RequestBody User user) {
		User userDetailUser = userService.createUser(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}


	@PostMapping("/token")
	public ResponseEntity<ResponseDTO> generateUser(@RequestBody User user) {
		String userDetailUser = userService.generateToken(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateUser(@PathVariable("id") long id , @RequestBody RequestDto requestDto) {
		User user = userService.updateUser(id, requestDto);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", user, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") Long id) {
		userService.deletebyID(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted id successfully ", id, HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		

	}
}