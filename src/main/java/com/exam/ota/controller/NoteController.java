package com.exam.ota.controller;

//NoteController.java



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     return new ResponseEntity<>(notes, HttpStatus.OK);
 }
 
 @RequestMapping(value ="/getNoteById/{id}", method = RequestMethod.GET)
 public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
     Note note = noteService.getById(id);
     if (note != null) {
         return new ResponseEntity<>(note, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
 
 @RequestMapping(value ="/updateNote/{id}", method = RequestMethod.PUT)
 public ResponseEntity<Note> updateNote(@PathVariable Long id, @Validated @RequestBody Note note) {
     Note updatedNote = noteService.update(id, note);
     if (updatedNote != null) {
         return new ResponseEntity<>(updatedNote, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
 
 @RequestMapping(value ="/deletNote/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
     boolean deleted = noteService.delete(id);
     if (deleted) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}
