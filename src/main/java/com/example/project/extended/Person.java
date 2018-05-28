package com.example.project.extended;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Person {
  private String firstName;
  private String lastName;
}
