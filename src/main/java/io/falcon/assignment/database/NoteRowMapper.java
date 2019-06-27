package io.falcon.assignment.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteRowMapper implements RowMapper<Note> {
  @Override
  public Note mapRow(ResultSet rs, int i) throws SQLException {
    Note note = new Note();
    note.setId(rs.getLong("id"));
    note.setContent(rs.getString("content"));
    note.setTimestamp(rs.getTimestamp("timestamp").toInstant());
    note.setLongestPalindromeSize(rs.getInt("longest_palindrome_size"));
    return note;
  }
}
