package com.fundoonotes.main.exception;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fundoonotes.main.dto.ResponseDTO;

@ControllerAdvice
public class FundooExceptionHandler {

	private static final String message = " Exception while processing REST Request";

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO(message, errMsg, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@ExceptionHandler(FundooMainException.class)
	public ResponseEntity<ResponseDTO> handlerAddressBookCustomException(FundooMainException fundooMainException) {
		ResponseDTO responseDTO = new ResponseDTO(message, fundooMainException.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ResponseDTO> missingRequestHeaderException(MissingRequestHeaderException exception) {
		ResponseDTO responseDTO = new ResponseDTO(message, "Enter your Token", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
