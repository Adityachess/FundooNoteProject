package com.project.fundoonotes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fundoonotes.dto.LabelDto;
import com.project.fundoonotes.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {

	Label save(LabelDto labelDto);

}
