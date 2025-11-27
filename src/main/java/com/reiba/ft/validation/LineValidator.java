package com.reiba.ft.validation;

import com.reiba.ft.validation.impl.Validator;

import java.util.regex.Pattern;

public final class LineValidator implements Validator {

  private static final Pattern TOKEN_DELIMITER_PATTERN =
          Pattern.compile("(,|;|\\s+|\\s*[–-]\\s+)");
  private static final Pattern INTEGER_PATTERN =
          Pattern.compile("[+-]?\\d+");

  @Override
  public boolean isValid(String line) {
    if (line == null) {
      return false;
    }

    String trimmedLine = line.trim();
    if (trimmedLine.isEmpty()) {
      return true;
    }

    String[] rawTokens = TOKEN_DELIMITER_PATTERN.split(trimmedLine);
    if (rawTokens.length == 0) {
      return false;
    }

    for (String rawToken : rawTokens) {
      String token = rawToken.trim();
      if (token.isEmpty()) {
        return false;
      }
      if (!INTEGER_PATTERN.matcher(token).matches()) {
        return false;
      }
    }

    return true;
  }
}
