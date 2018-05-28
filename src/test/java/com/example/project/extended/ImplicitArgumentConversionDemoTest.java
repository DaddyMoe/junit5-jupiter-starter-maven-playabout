package com.example.project.extended;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Demo of Implicit argument conversion.
 * Source:
 * https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-explicit
 *
 * <p/><p/>
 * Can also be done with Explicit Conversion:
 * https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-explicit
 */
public class ImplicitArgumentConversionDemoTest {


  @ParameterizedTest
  @ValueSource(strings = "SECONDS")
  void testWithImplicitArgumentConversion(TimeUnit argument) {
    assertNotNull(argument.name());
  }


  @ParameterizedTest
  @ValueSource(strings = "42 Cats") // This will implicitly instantiate a Book with title
  void testWithImplicitFallbackArgumentConversion(Book book) {
    assertEquals("42 Cats", book.getTitle());
  }

}

class Book {

  private final String title;

  private Book(String title) {
    this.title = title;
  }

  public static Book fromTitle(String title) {
    return new Book(title);
  }

  public String getTitle() {
    return this.title;
  }
}
