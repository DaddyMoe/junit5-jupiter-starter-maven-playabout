package com.example.project.extended;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

/**
 * The following example demonstrates a parameterized test that uses the @ValueSource annotation
 * to specify a String array as the source of arguments.
 */
public class ParameterizedTestDemoTest {

  @ParameterizedTest
  @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
  void palindromes(String candidate) {
    assertTrue(isPalindrome(candidate));
  }

  private boolean isPalindrome(String candidate) {
    return true;
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void testWithValueSource(int argument) {
    assertTrue(argument > 0 && argument < 4);
  }

  @ParameterizedTest
  @EnumSource(TimeUnit.class)
  void testWithEnumSource(TimeUnit timeUnit) {
    assertNotNull(timeUnit);
  }

  @ParameterizedTest
  @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
  void testWithEnumSourceInclude(TimeUnit timeUnit) {
    assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
  }


  /**
   * The @EnumSource allows exclusion of names from the enum constant pool .
   */
  @ParameterizedTest
  @EnumSource(value = TimeUnit.class, mode = EXCLUDE, names = {"DAYS", "HOURS"})
  void testWithEnumSourceExclude(TimeUnit timeUnit) {
    assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    assertTrue(timeUnit.name().length() > 5);
  }

  /**
   * The @EnumSource allows exclusion of names using regular expressions.
   */
  @ParameterizedTest
  @EnumSource(value = TimeUnit.class, mode = MATCH_ALL, names = "^(M|N).+SECONDS$")
  void testWithEnumSourceRegex(TimeUnit timeUnit) {
    String name = timeUnit.name();
    assertTrue(name.startsWith("M") || name.startsWith("N"));
    assertTrue(name.endsWith("SECONDS"));
  }

  /**
   * If you only need a single parameter, you can return a Stream of instances of the parameter
   * type as demonstrated in the following example.
   */
  @ParameterizedTest
  @MethodSource("stringProvider")
  void testWithSimpleMethodSource(String argument) {
    assertNotNull(argument);
  }

  private static Stream<String> stringProvider() {
    return Stream.of("foo", "bar");
  }


  /**
   * Streams for primitive types (DoubleStream, IntStream, and LongStream) are also supported
   */
  @ParameterizedTest
  @MethodSource("range")
  void testWithRangeMethodSource(int argument) {
    assertNotEquals(9, argument);
  }

  static IntStream range() {
    return IntStream.range(0, 20).skip(10);
  }


  /**
   * For multiple parameters, you need to return a collection or stream of Arguments instances
   */
  @ParameterizedTest
  @MethodSource("stringIntAndListProvider")
  void testWithMultiArgMethodSource(String str, int num, List<String> list) {
    assertEquals(3, str.length());
    assertTrue(num >= 1 && num <= 2);
    assertEquals(2, list.size());
  }

  /**
   * a collection or stream of Arguments instances
   */
  private static Stream<Arguments> stringIntAndListProvider() {
    return Stream.of(
        Arguments.of("foo", 1, Arrays.asList("a", "b")),
        Arguments.of("bar", 2, Arrays.asList("x", "y"))
    );
  }

  /**
   * {@link CsvSource} allows you to express argument lists as comma-separated values (i.e., String literals).
   */
  @ParameterizedTest
  @CsvSource({"foo, 1", "bar, 2", "'baz, qux', 3"})
  void testWithCsvSource(String first, int second) {
    assertNotNull(first);
    assertNotEquals(0, second);
  }

  /**
   * {@link CsvFileSource} lets you use CSV files from the classpath. Each line from a CSV file results in
   * one invocation of the parameterized test
   */

  @ParameterizedTest
  @CsvFileSource(resources = "/two-column.csv", numLinesToSkip = 1)
  void testWithCsvFileSource(String first, int second) {
    assertNotNull(first);
    assertNotEquals(0, second);
  }
}
