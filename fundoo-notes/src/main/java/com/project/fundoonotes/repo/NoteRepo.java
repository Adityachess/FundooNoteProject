package com.project.fundoonotes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {

	Note save(NoteDto note);

}
