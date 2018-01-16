package com.example.boot.m.a.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.m.a.easy_notes.*;



@RestController
public class NotesController {
	
	@Autowired
	NoteService noteService;
	
	//Get all notes
	@RequestMapping("/notes")
	public List<Notes> getAllNotes()
	{ System.out.println("ccscs");
		return noteService.getAllNotes();
	}
	
	// Post a note
	//The @RequestBody annotation is used to bind the request body with a method parameter.
	@PostMapping("/notes")
	public Notes createNote( @RequestBody Notes note)
	{
		return noteService.createNote(note);
	}
	
	//Get a single note....
	//In the above method, we are returning a ResponseEntity<Note> instead of Note. 
	//The ResponseEntity class gives us more flexibility while returning a response from the api.
	@GetMapping("/notes/{id}")
	public ResponseEntity<Notes> getNotesById(@PathVariable(value="id") Long noteId)
	{
		return noteService.getNotesById(noteId);
		//Notes notes=notesRepository.findOne(noteId);
		//if(notes == null) {
	    //    return ResponseEntity.notFound().build();
	   // }
	   // return ResponseEntity.ok().body(notes);
	}
	
	//Update a note
	@PutMapping("/notes/{id}")
	public ResponseEntity<Notes> updateNote(@PathVariable (value= "id") Long noteId,@RequestBody Notes noteDetails)
	{
		return noteService.updateNote(noteId,noteDetails);
		
	}
	/*
	 * Notes notes=notesRepository.findOne(noteId);
		if(notes==null)
		{
			return ResponseEntity.notFound().build();
		}
		notes.setTitle(noteDetails.getTitle());
		notes.setContent(noteDetails.getContent());
		Notes updatednote=notesRepository.save(notes);
		return ResponseEntity.ok(updatednote);
	}
	*/
	//Delete a note
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Notes> deleteNote(@PathVariable(value = "id") Long noteId) {
	    return noteService.deleteNote(noteId);
	}

}
