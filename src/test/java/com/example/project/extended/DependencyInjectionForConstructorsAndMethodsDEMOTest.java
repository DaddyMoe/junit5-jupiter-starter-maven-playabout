package com.example.project.extended;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * As one of the major changes in JUnit Jupiter, both test constructors and methods
 * are now permitted to have parameters.
 * <p>
 * <p>
 * The following demonstrates how to have TestInfo injected into a test constructor,
 */
@DisplayName("TestInfo Demo")
public class DependencyInjectionForConstructorsAndMethodsDEMOTest {

  DependencyInjectionForConstructorsAndMethodsDEMOTest(TestInfo testInfo) {
    assertEquals("TestInfo Demo", testInfo.getDisplayName());
  }

  @BeforeEach
  void init(TestInfo testInfo) {
    String displayName = testInfo.getDisplayName();
    assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
  }

  @Test
  @DisplayName("TEST 1")
  @Tag("my-tag")
  void test1(TestInfo testInfo) {
    assertEquals("TEST 1", testInfo.getDisplayName());
    assertTrue(testInfo.getTags().contains("my-tag"));
  }

  @Test
  void test2() {
  }
}
