package com.exam.ota.service;

import java.util.List;

import com.exam.ota.model.Note;

public interface NoteService {
	
	Note create(Note note);
	    
    List<Note> getAll();
    
    Note getById(Long id);
    
    Note update(Long id, Note note);
    
    boolean delete(Long id);

}
