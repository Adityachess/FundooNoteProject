package com.project.fundoonotes.service;

import java.util.List;

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;

public interface INoteService {

	Note geNotesById(int id);

	List<Note> getAllNotes();

	void deletebyID(int id);

	Note createNote(NoteDto noteDto);

	Note updateNoteByID(int id, NoteDto noteDto);

}
