package com.example.boot.m.a.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.boot.m.a.easy_notes.*;

@Service
public class NoteService {
	
	@Autowired
	NotesRepository notesRepository;
	
	public List<Notes> getAllNotes()
	{
		List<Notes> a=new ArrayList<Notes>();
	    notesRepository.findAll().forEach(a::add);
	    
	    System.out.println("hello");
	    
	    return a;
	}
	//Create a note.....
	public Notes createNote(Notes note)
	{
		return notesRepository.save(note);
	}
	// Find a note by id...
	public ResponseEntity<Notes> getNotesById( Long noteId)
	{
		Notes notes=notesRepository.findOne(noteId);
		if(notes == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(notes);
	}
	//Update a note....
	public ResponseEntity<Notes> updateNote(Long noteId,Notes noteDetails)
	{
		Notes notes=notesRepository.findOne(noteId);
		if(notes==null)
		{
			return ResponseEntity.notFound().build();
		}
		notes.setTitle(noteDetails.getTitle());
		notes.setContent(noteDetails.getContent());
		Notes updatednote=notesRepository.save(notes);
		return ResponseEntity.ok(updatednote);
	}
	//To delete a note...
	public ResponseEntity<Notes> deleteNote(Long noteId) {
	    Notes note = notesRepository.findOne(noteId);
	    if(note == null) {
	        return ResponseEntity.notFound().build();
	    }

	    notesRepository.delete(note);
	    return ResponseEntity.ok().build();
	}
}
