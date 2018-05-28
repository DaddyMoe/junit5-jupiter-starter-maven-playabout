package com.example.project.extended;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static java.lang.System.out;

/**
 * A Test may be enabled or disabled based on the value of the named environment variable from the underlying
 * operating system via the @EnabledIfEnvironmentVariable and @DisabledIfEnvironmentVariable annotations
 */
public class EnvironmentVariableConditionsDemoTest {

  @Test
  @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
  void onlyOnStagingServer() {
    out.println("TEST: onlyOnStagingServer");
  }

  @Test
  @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
  void notOnDeveloperWorkstation() {
    out.println("TEST: notOnDeveloperWorkstation");
  }
}
