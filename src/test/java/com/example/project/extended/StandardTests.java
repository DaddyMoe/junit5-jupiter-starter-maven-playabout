package com.example.project.extended;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StandardTests {

  @BeforeAll
  static void initAll() {
  }

  @BeforeEach
  void init() {
  }

  @Test
  void succeedingTest() {
  }

  @Test
  @MYFastMetaAnnotation
  void mYFastMetaAnnotation(){
    assertEquals("fast test","fast test");
  }

  @Test
  void failingTest() {
    fail("a failing test");
  }

  @Test
  @Disabled("for demonstration purposes")
  void skippedTest() {
    // not executed
  }

  @AfterEach
  void tearDown() {
  }

  @AfterAll
  static void tearDownAll() {
  }
}
