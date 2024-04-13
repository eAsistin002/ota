package com.exam.ota.service.impl;




import org.springframework.stereotype.Service;

import com.exam.ota.model.Note;
import com.exam.ota.service.NoteService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteServiceImpl implements NoteService {
 
 private List<Note> notes = new ArrayList<>();
 private AtomicLong counter = new AtomicLong();
 
 @Override
 public Note create(Note note) {
     note.setId(counter.incrementAndGet());
     notes.add(note);
     return note;
 }
 
 @Override
 public List<Note> getAll() {
     return notes;
 }
 
 @Override
 public Note getById(Long id) {
     return notes.stream()
             .filter(note -> note.getId().equals(id))
             .findFirst()
             .orElse(null);
 }
 
 @Override
 public Note update(Long id, Note updatedNote) {
     Note existingNote = getById(id);
     if (existingNote != null) {
         existingNote.setTitle(updatedNote.getTitle());
         existingNote.setBody(updatedNote.getBody());
         return existingNote;
     }
     return null;
 }
 
 @Override
 public boolean delete(Long id) {
     return notes.removeIf(note -> note.getId().equals(id));
 }
}
