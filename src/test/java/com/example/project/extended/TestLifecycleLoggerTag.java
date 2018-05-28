package com.example.project.extended;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface TestLifecycleLoggerTag {
  Logger LOG = Logger.getLogger(TestLifecycleLoggerTag.class.getName());

  @BeforeAll
  default void beforeAllTests() {
    LOG.info("Before all tests");
  }

  @AfterAll
  default void afterAllTests() {
    LOG.info("After all tests");
  }

  @BeforeEach
  default void beforeEachTest(TestInfo testInfo) {
    LOG.info(() -> String.format("About to execute [%s]",
        testInfo.getDisplayName()));
  }

  @AfterEach
  default void afterEachTest(TestInfo testInfo) {
    LOG.info(() -> String.format("Finished executing [%s]",
        testInfo.getDisplayName()));
  }


  class TestLifecycleLoggerTagTest implements TestLifecycleLoggerTag {

    @Test
    void publishValue1(TestReporter testReporter) {
      testReporter.publishEntry("key", "value1");
    }

    @Test
    void publishValue2(TestReporter testReporter) {
      testReporter.publishEntry("key", "value2");
    }

  }
}