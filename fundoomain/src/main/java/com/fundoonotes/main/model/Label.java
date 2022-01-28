package com.fundoonotes.main.model;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Label {
	
	private int id;
	private String name;
	private Date createdDate;
	private Date modifiedDate;

	
  
}

