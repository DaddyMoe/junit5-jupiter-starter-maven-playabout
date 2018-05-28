package com.example.project.extended;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;

/**
 * In JUnit Jupiter you should use TestReporter where you used to print information to stdout or stderr in
 * JUnit 4. JUnit Jupiter will output all reported entries to stdout.
 */
public class PrintTestInfoDemoTest {

  @Test
  void reportSingleValue(TestReporter testReporter) {
    testReporter.publishEntry("a key", "a value");
  }

  @Test
  void reportSeveralValues(TestReporter testReporter) {
    HashMap<String, String> values = new HashMap<>();
    values.put("user name", "dk38");
    values.put("award year", "1974");

    testReporter.publishEntry(values);
  }
}
