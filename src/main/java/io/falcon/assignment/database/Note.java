package io.falcon.assignment.database;

import java.time.Instant;

public class Note {

    private String content;
    private Instant timestamp;
    private int longestPalindromeSize;

    public Note() {
    }

    public Note(String content, Instant timestamp, int longestPalindromeSize) {
        this.content = content;
        this.timestamp = timestamp;
        this.longestPalindromeSize = longestPalindromeSize;
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
