package io.falcon.assignment.api;

import io.falcon.assignment.database.Note;
import io.falcon.assignment.database.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NoteAPI {

  private NoteRepository noteRepository;

  @Autowired
  public NoteAPI(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  @GetMapping("/api/all-notes")
  public ResponseEntity<List<NoteDtoDisplay>> allNotes() {
    List<Note> notes = noteRepository.getAll();

    if(notes == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    List<NoteDtoDisplay> noteDtoDisplays = notes.stream()
        .map(NoteAPI::getDtosFromEntities)
        .collect(Collectors.toList());

    return new ResponseEntity<>(noteDtoDisplays, HttpStatus.OK);
  }

}
