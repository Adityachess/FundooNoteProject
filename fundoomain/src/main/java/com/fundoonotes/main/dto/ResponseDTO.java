package com.fundoonotes.main.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@AllArgsConstructor

public class ResponseDTO {
	public String message;
	public Object data;
	public HttpStatus httpStatus;

	public ResponseDTO(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

}
