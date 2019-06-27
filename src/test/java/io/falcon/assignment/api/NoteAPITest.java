package io.falcon.assignment.api;

import io.falcon.assignment.database.Note;
import io.falcon.assignment.database.NoteRepository;
import io.falcon.assignment.palindrome.PalindromeFinder;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = NoteAPI.class)
public class NoteAPITest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private NoteRepository noteRepository;
  @MockBean
  private SimpMessagingTemplate template;
  @MockBean
  private PalindromeFinder palindromeFinder;

  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ");

  private List<Note> notes;
  private NoteDtoPayload noteDtoPayload;
  private Instant now;
  private String payloadContent;
  private String payloadTimestamp;

  @Before
  public void setup() {
    now = Instant.now();
    Note note = new Note("content", now, 1);
    Note note2 = new Note("contentll", now, 2);
    notes = Arrays.asList(note, note2);

    noteDtoPayload = new NoteDtoPayload();
    noteDtoPayload.setContent("contentNotellkkll");
    noteDtoPayload.setTimestamp("2018-10-09 00:12:12+0100");
    payloadContent = noteDtoPayload.getContent();
    payloadTimestamp = noteDtoPayload.getTimestamp();
  }

  @Test
  public void allNotesOk() throws Exception {
    when(noteRepository.getAll()).thenReturn(notes);

    ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
    String timestamp = DATE_TIME_FORMATTER.format(zonedDateTime);

    mockMvc.perform(get("/api/all-notes")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(2)))
        .andExpect(jsonPath("$[0].content", is("content")))
        .andExpect(jsonPath("$[0].timestamp", is(timestamp)))
        .andExpect(jsonPath("$[0].longest_palindrome_size", is(1)))
        .andExpect(jsonPath("$[1].content", is("contentll")))
        .andExpect(jsonPath("$[1].timestamp", is(timestamp)))
        .andExpect(jsonPath("$[1].longest_palindrome_size", is(2)));
  }

  @Test
  public void notesNotFound() throws Exception {
    when(noteRepository.getAll()).thenReturn(null);

    mockMvc.perform(get("/api/all-notes")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isInternalServerError());
  }

}
