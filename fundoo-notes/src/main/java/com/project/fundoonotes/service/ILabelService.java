package com.project.fundoonotes.service;

import java.util.List;


import com.project.fundoonotes.dto.LabelDto;
import com.project.fundoonotes.model.Label;

public interface ILabelService {

	Label updateLabel(int id, LabelDto labelDto);

	void deleteLabelbyID(int id);

	List<Label> getAllLabels();

	Label geLabelById(int id);


	Label creatLabel(LabelDto labelDto);

}
