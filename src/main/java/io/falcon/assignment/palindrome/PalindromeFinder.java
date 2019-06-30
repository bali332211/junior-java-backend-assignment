package io.falcon.assignment.palindrome;

public interface PalindromeFinder {

    /**
     * Retrieves the longest palindrome's length in the given String.
     *
     * <p>
     * Only alphabetical characters are considered, any other character
     * is disregarded during calculation.
     *
     * @param content the String to be searched.
     * @return the longest palindrome's length within the String.
     */
    int getLongestPalindromeSize(String content);
}
