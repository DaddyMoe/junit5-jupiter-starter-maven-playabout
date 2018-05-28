package com.example.project.extended;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.System.out;
import static org.junit.jupiter.api.condition.OS.*;

/**
 * Enabled or disabled a Given Test on a particular operating system via the @EnabledOnOs and @DisabledOnOs annotations.
 */
public class OperatingSystemConditionsDemoTest {

  @Test
  @EnabledOnOs(MAC)
  void onlyOnMacOs() {
    out.println("TEST: onlyOnMacOs");
  }

  @TestOnMac
  void testOnMac() {
    out.println("TEST: testOnMac via Custom meta annotation Interface");

  }

  @Test
  @EnabledOnOs({LINUX, MAC})
  void onLinuxOrMac() {
    out.println("TEST: onLinuxOrMac");
  }

  @Test
  @EnabledOnOs({SOLARIS})
  void onSolarisOnly() {
    out.println("TEST: onSolarisOnly");
  }

  @Test
  @DisabledOnOs(WINDOWS)
  void notOnWindows() {
    out.println("TEST: notOnWindows");
  }

  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  @Test
  @EnabledOnOs(MAC)
  @interface TestOnMac {
  }
}
