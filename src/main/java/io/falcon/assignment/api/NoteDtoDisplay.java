package io.falcon.assignment.api;

public class NoteDtoDisplay {

    private String content;
    private String timestamp;
    private int longest_palindrome_size;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getLongest_palindrome_size() {
        return longest_palindrome_size;
    }

    public void setLongest_palindrome_size(int longest_palindrome_size) {
        this.longest_palindrome_size = longest_palindrome_size;
    }
}
