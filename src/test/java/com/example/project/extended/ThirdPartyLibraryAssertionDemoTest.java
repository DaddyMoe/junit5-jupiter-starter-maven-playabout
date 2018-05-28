package com.example.project.extended;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * The JUnit team recommends the use of third-party assertion libraries such as AssertJ, Hamcrest, Truth, etc
 *
 * This is a demo with Hamcrest
 *
 */
public class ThirdPartyLibraryAssertionDemoTest {

  @Test
  void assertWithHamcrestMatcher() {
    assertThat(2 + 1, is(equalTo(3)));
  }

  @Test
  void assertWithAssertJ() {
    then(2 + 1).isEqualTo(3);
  }
}
