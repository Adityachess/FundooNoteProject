package com.fundoonotes.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fundoonotes.user.dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_list")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String mobileNumber;
	public String password;

	public void updateUser(RequestDto requestDto) {
	  this.mobileNumber= requestDto.getMobileNumber();
	  this.password=requestDto.getPassword();

	}
	
	public User (RequestDto requestDto) {
		this.updateUser(requestDto);
	}
}
