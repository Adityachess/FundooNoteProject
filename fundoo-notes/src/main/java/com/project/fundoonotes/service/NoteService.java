package com.project.fundoonotes.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;
import com.project.fundoonotes.repo.NoteRepo;

@Service
public class NoteService implements INoteService {

	@Autowired
	private NoteRepo noteRepo;

	   @Override
	    public Note updateNoteByID(int id, NoteDto noteDto) {
		   Note note = this.geNotesById(id);
	        note.updateNote(noteDto);
	        return noteRepo.save(note);
	       }

	

	@Override
	public void deletebyID(int id) {
		noteRepo.deleteById(id);
	}

	@Override
	public List<Note> getAllNotes() {
		return noteRepo.findAll();
	}

	@Override
	public Note geNotesById(int id) {
		return noteRepo.findById(id).get();
	}

	@Override
	public Note createNote(NoteDto noteDto) {
		Note note = null;
		note = new Note(noteDto);
		return noteRepo.save(note);
	}

}
