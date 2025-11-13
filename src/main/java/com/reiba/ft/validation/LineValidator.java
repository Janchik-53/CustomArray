package com.reiba.ft.validation;
import java.util.regex.Pattern;//??????????

public final class LineValidator implements Validator {
  private  final Pattern SPLIT = Pattern.compile("(,|;|\\s+|\\s*[–-]\\s+)");
  private  final Pattern INT   = Pattern.compile("[+-]?\\d+");

  @Override
  public boolean isValid(String line) {
    if (line == null) return false;
    String s = line.trim();
    if (s.isEmpty()) return true;

    String[] tokens = SPLIT.split(s);
    if (tokens.length == 0) return false;

    for (String t : tokens) {
      String tt = t.trim();
      if (tt.isEmpty()) return false;
      if (!INT.matcher(tt).matches()) return false;
    }
    return true;
  }
}
