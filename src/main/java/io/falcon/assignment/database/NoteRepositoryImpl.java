package io.falcon.assignment.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Repository for operations on the connected database.
 */
@Repository
public class NoteRepositoryImpl implements NoteRepository{

  private NamedParameterJdbcTemplate template;

  @Autowired
  public NoteRepositoryImpl(NamedParameterJdbcTemplate template) {
    this.template = template;
  }


  /**
   * Returns all <code>Note</code> instances.
   *
   * @return all Notes
   */
  @Override
  public List<Note> getAll() {
    return template.query("select * from notes", new NoteRowMapper());
  }


  /**
   * Saves a given <code>Note</code>. Use the returned instance for further operations as the save operation might have changed the
   * entity instance completely.
   *
   * @param note must not be {@literal null}.
   * @return the saved entity will never be {@literal null}.
   */
  @Override
  @Transactional
  public void save(Note note) {
    final String sql =
        "insert into notes" +
            "(content, timestamp , longest_palindrome_size) values" +
            "(:content,:timestamp,:longestPalindromeSize)";
    KeyHolder holder = new GeneratedKeyHolder();

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("content", note.getContent())
        .addValue("timestamp", Timestamp.from(note.getTimestamp()))
        .addValue("longestPalindromeSize", note.getLongestPalindromeSize());
    template.update(sql, param, holder);
  }
}
