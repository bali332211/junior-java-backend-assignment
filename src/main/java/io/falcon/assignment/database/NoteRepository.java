package io.falcon.assignment.database;

import java.util.List;

public interface NoteRepository {

  List<Note> getAll();
  void save(Note note);

}
