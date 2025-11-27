package com.reiba.ft;

import com.reiba.ft.validation.LineValidator;
import com.reiba.ft.validation.impl.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineValidatorTest {

  private final Validator validator = new LineValidator();

  @Test
  void validLinesPass() {
    assertTrue(validator.isValid(""));
    assertTrue(validator.isValid("1; 2; 3"));
    assertTrue(validator.isValid("1,2,3"));
    assertTrue(validator.isValid("3  4   7"));
    assertTrue(validator.isValid("1 - 2 - 3"));
    assertTrue(validator.isValid("-5; 0; 10"));
  }

  @Test
  void invalidLinesFail() {
    assertFalse(validator.isValid("1y1 21 32"));
    assertFalse(validator.isValid("1; 2; x3; 6..5; 77"));
    assertFalse(validator.isValid(" ; "));
  }
}
