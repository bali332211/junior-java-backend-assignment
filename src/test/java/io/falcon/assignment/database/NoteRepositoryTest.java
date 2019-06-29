package io.falcon.assignment.database;

import io.falcon.assignment.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = RANDOM_PORT)
@SqlGroup({
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/db/migration/schema.sql"),
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/db/migration/data.sql")})
public class NoteRepositoryTest {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NamedParameterJdbcTemplate template;

    private Note note;
    private Instant now;

    @Before
    public void setup() {
        note = new Note();
        note.setContent("contentNotellkkll");
        now = Instant.now();
        note.setTimestamp(now);
        note.setLongestPalindromeSize(6);
    }

    @Test
    public void save() {
        assertThat(noteRepository.getAll().size(), is(2));
        noteRepository.save(note);

        List<Note> allNotesNew = noteRepository.getAll();
        assertThat(allNotesNew.size(), is(3));

        Note newNote = allNotesNew.get(allNotesNew.size() - 1);
        assertThat(newNote.getContent(), is("contentNotellkkll"));
        assertThat(newNote.getTimestamp(), is(now));
        assertThat(newNote.getLongestPalindromeSize(), is(6));
    }

    @Test
    public void getAll() {
        List<Note> allNotes = noteRepository.getAll();
        assertFalse(allNotes.isEmpty());
        assertThat(allNotes.size(), is(2));
        assertThat(allNotes.get(0).getContent(), is("abrakadabra"));
    }
}
