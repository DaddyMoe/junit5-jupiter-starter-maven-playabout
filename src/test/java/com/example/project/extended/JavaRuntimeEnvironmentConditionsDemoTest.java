package com.example.project.extended;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;

import static java.lang.System.out;
import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;

/**
 *  A Test may be enabled or disabled on a particular version of the Java Runtime Environment (JRE)
 *  via the @EnabledOnJre and @DisabledOnJre annotations.
 */
public class JavaRuntimeEnvironmentConditionsDemoTest {

  @Test
  @EnabledOnJre(JAVA_8)
  void onlyOnJava8() {
    // ...
    out.println("TEST: onlyOnJava8");
  }

  @Test
  @EnabledOnJre({ JAVA_9, JAVA_10 })
  void onJava9Or10() {
    out.println("TEST: onJava9Or10");
  }

  @Test
  @DisabledOnJre(JAVA_9)
  void notOnJava9() {
    out.println("TEST: notOnJava9");
  }
}
