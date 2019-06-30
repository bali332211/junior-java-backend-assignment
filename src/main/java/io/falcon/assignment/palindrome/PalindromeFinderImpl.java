package io.falcon.assignment.palindrome;

import org.springframework.stereotype.Component;

@Component
public class PalindromeFinderImpl implements PalindromeFinder {

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLongestPalindromeSize(String content) {
        String contentTrimmed = trimToAlphabetical(content);

        int longestPalindromeSize = 0;
        for (int startIndex = 0; startIndex < content.length(); startIndex++) {

            int palindromeSize = getLongestPalindromeSizeFromAllSubstrings(contentTrimmed, startIndex);
            longestPalindromeSize = Math.max(longestPalindromeSize, palindromeSize);
        }
        return longestPalindromeSize;
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

    private int getLongestPalindromeSizeFromAllSubstrings(String content, int startIndex) {
        int longestPalindromeSize = 0;
        for (int i = startIndex; i < content.length(); i++) {
            int stringSliceLength = i + 1 - startIndex;

            if (isStringSlicePalindrome(content, startIndex, i)) {
                longestPalindromeSize = Math.max(longestPalindromeSize, stringSliceLength);
            }
        }
        return longestPalindromeSize;
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
