package com.example.project.extended;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * This demos pred conditions scenarios that need to be met before running test.
 * EG. dependent on CI environment name.
 */
public class AssumptionsDemoTest {

  @Test
  void testOnlyOnCiServer() {
    assumeTrue("CI".equals(System.getenv("ENV")));
    // remainder of test
    assertEquals("a string", "a string"); // wont be reached
  }

  @Test
  void testOnlyOnDeveloperWorkstation() {
    assumeTrue("DEV".equals(System.getenv("ENV")),
        () -> "Aborting test: not on developer workstation");
    // remainder of test
    assertEquals("a string", "a string"); // wont be reached
  }

  @Test
  void testInAllEnvironments() {
    assumingThat("CI".equals(System.getenv("ENV")),
        () -> {
          // perform these assertions only on the CI server
          assertEquals(2, 2);
        });

    // perform these assertions in all environments
    assertEquals("a string", "a string"); // will be reached in either case
  }
}
