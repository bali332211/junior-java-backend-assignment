package io.falcon.assignment.database;

import java.util.List;

public interface NoteRepository {

    /**
     * Returns all {@link Note} instances from notes table.
     */
    List<Note> getAll();

    /**
     * Saves a given {@link Note} or updates an existing entity instance.
     *
     * @param note must not be {@literal null}.
     */
    void save(Note note);

}
