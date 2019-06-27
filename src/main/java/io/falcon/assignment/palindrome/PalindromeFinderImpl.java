package io.falcon.assignment.palindrome;

import org.springframework.stereotype.Component;

@Component
public class PalindromeFinderImpl implements PalindromeFinder {

  @Override
  public int getHighestPalindromeSize(String content) {
    String contentTrimmed = trimToAlphaetical(content);

    int highestPalindromeSize = 0;
    for (int startIndex = 0; startIndex < content.length(); startIndex++) {

      int palindromeSize = tryWithAllSubstringsFrom(contentTrimmed, startIndex);
      highestPalindromeSize = Math.max(highestPalindromeSize, palindromeSize);
    }
    return highestPalindromeSize;
  }

  private String trimToAlphaetical(String content) {
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < content.length(); i++) {
      char currentChar = content.charAt(i);
      if(Character.isAlphabetic(currentChar)) {
        stringBuilder.append(currentChar);
      }
    }
    return stringBuilder.toString().toLowerCase();
  }


}
