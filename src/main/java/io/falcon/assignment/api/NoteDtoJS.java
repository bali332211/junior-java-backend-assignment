package io.falcon.assignment.api;

public class NoteDtoJS {

  private String content;
  private long timestamp;
  private int longest_palindrome_size;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Retrieves the milliseconds passed since the epoch for Date constructor in JS.
     */
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getLongest_palindrome_size() {
        return longest_palindrome_size;
    }

    public void setLongest_palindrome_size(int longest_palindrome_size) {
        this.longest_palindrome_size = longest_palindrome_size;
    }
}
