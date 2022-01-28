package com.fundoonotes.main.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

	private int id;
	private String title;
	private String description;
	private Date createdDate;
	private Date modifiedDate;

}
