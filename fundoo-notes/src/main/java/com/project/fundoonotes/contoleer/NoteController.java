package com.project.fundoonotes.contoleer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;
import com.project.fundoonotes.model.Response;
import com.project.fundoonotes.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	/**
	 * @param url
	 * @return All notes
	 */
	
	@GetMapping("/getAll")
	public ResponseEntity<Response> getAllNotes() {
		List<Note> noteList = null;
		noteList = noteService.getAllNotes();
		Response respDTO = new Response("Get call success", noteList);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
	 * 
	 * @param Note Id
	 * @return Note details for particular id
	 */

	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getNotesById(@PathVariable("id") int id) {
		Note noteDetails = null;
		noteDetails = noteService.geNotesById(id);
		Response respDTO = new Response("Get call success for id:" + id, noteDetails);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
	 * 
	 * @param NoteDto
	 * @return Note And HTTP status
	 */

	@PostMapping("/create")
	public ResponseEntity<Response> createNotes( @RequestBody NoteDto noteDto) {
		Note createNote = null;
		createNote = noteService.createNote(noteDto);
		Response respDTO = new Response("created Note successfully", createNote);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
	 * 
	 * @param NoteId ,NoteDto
	 * @return Updated PersonData And HTTP status
	 */

	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateNote(@PathVariable("id") int id,
			@RequestBody NoteDto noteDto) {
		Note createNote = null;
		createNote = noteService.updateNoteByID(id, noteDto);
		Response respDTO = new Response("Updated Note successfully", createNote);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
	 * 
	 * @param NoteId
	 * @return String if id is removed
	 */

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Response> deleteNote(@PathVariable("id") int id) {
		noteService.deletebyID(id);
		Response respDTO = new Response("Deleted Note Successfully",
				"deleted NoteId is :" + id);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

}