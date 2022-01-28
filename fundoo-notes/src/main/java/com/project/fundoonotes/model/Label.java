package com.project.fundoonotes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.fundoonotes.dto.LabelDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "label")
public class Label {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private Date createdDate;
	private Date modifiedDate;

	public void updateLabel(LabelDto labelDto) {
		this.name = labelDto.getName();
		this.createdDate = new Date();
		this.modifiedDate = new Date();

	}
	
	public Label(LabelDto labelDto) {
		this.updateLabel(labelDto);
		}
  
}

