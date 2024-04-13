package com.exam.ota.controller;

//NoteController.java



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.exam.ota.exception.NoteNotFoundException;
import com.exam.ota.model.Note;
import com.exam.ota.service.NoteService;

import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {
 
 @Autowired
 private NoteService noteService;
 
 @RequestMapping(value ="/createNote", method = RequestMethod.POST)
 public ResponseEntity<Note> createNote(@Valid @RequestBody Note note) {
     Note createdNote = noteService.create(note);
     return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
 }
 
 @RequestMapping(value ="/list", method = RequestMethod.GET)
 public ResponseEntity<List<Note>> getAllNotes() {
     List<Note> notes = noteService.getAll();
     if(notes.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);

     } else {
         return new ResponseEntity<>(notes, HttpStatus.OK);
     }
 }
 
 @RequestMapping(value ="/getNoteById/{id}", method = RequestMethod.GET)
 public ResponseEntity<?> getNoteById(@PathVariable Long id) {
     Note note = noteService.getById(id);
     if (note != null) {
         return new ResponseEntity<>(note, HttpStatus.OK);
     } else {
         throw new NoteNotFoundException(id);
     }
 }
 
 @RequestMapping(value ="/updateNote/{id}", method = RequestMethod.PUT)
 public ResponseEntity<?> updateNote(@PathVariable Long id, @Validated @RequestBody Note note) {
     Note updatedNote = noteService.update(id, note);
     if (updatedNote != null) {
         return ResponseEntity.ok("Note updated successfully");
     } else {
         throw new NoteNotFoundException(id);
     }
 }
 
 @RequestMapping(value ="/deleteNote/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<?> deleteNote(@PathVariable Long id) {
     boolean deleted = noteService.delete(id);
     System.out.println(deleted);
     if (deleted) {
         return ResponseEntity.ok("Note deleted successfully");
     } else {
         throw new NoteNotFoundException(id);
     }

 }
}
