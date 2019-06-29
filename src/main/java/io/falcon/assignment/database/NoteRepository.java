package io.falcon.assignment.database;

import java.util.List;

/**
 * Interface for operations on <code>Note</code> repository.
 */
public interface NoteRepository {

    List<Note> getAll();

    void save(Note note);

}
