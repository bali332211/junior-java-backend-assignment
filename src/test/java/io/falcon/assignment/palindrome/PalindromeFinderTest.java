package io.falcon.assignment.palindrome;

import io.falcon.assignment.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = RANDOM_PORT)
public class PalindromeFinderTest {

  @Autowired
  private PalindromeFinder palindromeFinder;

  @Test
  public void addPalindromeSize() {
    assertThat(palindromeFinder.getHighestPalindromeSize("contentNotellkkll"), is(6));
    assertThat(palindromeFinder.getHighestPalindromeSize("vv/%/vv"), is(4));
    assertThat(palindromeFinder.getHighestPalindromeSize(".$@$."), is(0));
    assertThat(palindromeFinder.getHighestPalindromeSize("c"), is(1));
  }
}
