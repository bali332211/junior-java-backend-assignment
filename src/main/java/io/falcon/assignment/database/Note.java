package io.falcon.assignment.database;

import java.time.Instant;

public class Note {

  private long id;
  private String content;
  private Instant timestamp;
  private int longestPalindromeSize;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public int getLongestPalindromeSize() {
    return longestPalindromeSize;
  }

  public void setLongestPalindromeSize(int longestPalindromeSize) {
    this.longestPalindromeSize = longestPalindromeSize;
  }
}
