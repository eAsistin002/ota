package com.exam.ota.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CustomExceptionHandler {

 @ExceptionHandler
 @ResponseBody
 @ResponseStatus(HttpStatus.NOT_FOUND)
 ResponseEntity<String> handleNoteNotFoundException(NoteNotFoundException ex) {
     return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
 }
 
 @ExceptionHandler(NoHandlerFoundException.class)
 @ResponseBody
 @ResponseStatus(HttpStatus.NOT_FOUND)
 ResponseEntity<String> handleNoHandlerFoundException(NoHandlerFoundException ex) {
     return new ResponseEntity<>("Endpoint not found", HttpStatus.NOT_FOUND);
 }
 
}
