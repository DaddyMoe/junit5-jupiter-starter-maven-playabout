package com.example.project.extended;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case")
public class DisplayNameDemoTest {

  @Test
  @DisplayName("Custom test name containing spaces")
  void testWithDisplayNameContainingSpaces() {
  }

  @Test
  @DisplayName("╯°□°）╯")
  void testWithDisplayNameContainingSpecialCharacters() {
  }

  @Test
  @DisplayName("😱")
  void testWithDisplayNameContainingEmoji() {
  }
}
