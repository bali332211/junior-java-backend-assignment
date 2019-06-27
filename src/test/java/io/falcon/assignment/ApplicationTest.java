package io.falcon.assignment;

import io.falcon.assignment.palindrome.PalindromeFinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = RANDOM_PORT)
public class ApplicationTest {

  @MockBean
  private PalindromeFinder palindromeFinder;

  @Test
  public void contextLoads() {
  }

}