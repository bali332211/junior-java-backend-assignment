package io.falcon.assignment.palindrome;

import org.springframework.stereotype.Component;

@Component
public class PalindromeFinderImpl implements PalindromeFinder {

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
    @Override
    public int getHighestPalindromeSize(String content) {
        String contentTrimmed = trimToAlphabetical(content);

        int highestPalindromeSize = 0;
        for (int startIndex = 0; startIndex < content.length(); startIndex++) {

            int palindromeSize = tryWithAllSubstringsFrom(contentTrimmed, startIndex);
            highestPalindromeSize = Math.max(highestPalindromeSize, palindromeSize);
        }
        return highestPalindromeSize;
    }

    private String trimToAlphabetical(String content) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < content.length(); i++) {
            char currentChar = content.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                stringBuilder.append(currentChar);
            }
        }
        return stringBuilder.toString().toLowerCase();
    }

    private int tryWithAllSubstringsFrom(String content, int startIndex) {
        int highestPalindromeSize = 0;
        for (int i = startIndex; i < content.length(); i++) {
            int stringSliceLength = i + 1 - startIndex;

            if (isStringSlicePalindrome(content, startIndex, i)) {
                highestPalindromeSize = Math.max(highestPalindromeSize, stringSliceLength);
            }
        }
        return highestPalindromeSize;
    }

    private boolean isStringSlicePalindrome(String content, int startIndex, int endIndex) {
        int stringSliceLength = endIndex + 1 - startIndex;

        for (int i = 0; i < stringSliceLength / 2; i++) {
            if (content.charAt(startIndex + i) != content.charAt(endIndex - i)) {
                return false;
            }
        }
        return true;
    }
}
