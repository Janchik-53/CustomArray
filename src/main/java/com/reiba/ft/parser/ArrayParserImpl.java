
package com.reiba.ft.parser;
import com.reiba.ft.parser.impl.ArrayParser;

  public class ArrayParserImpl implements ArrayParser {

    @Override
    public int[] parse(String line) {
      if (line == null || line.trim().isEmpty()) {
        return new int[0];
      }

      String[] stringNumbers = line.split("(,|;|\\s+|\\s*[–-]\\s+)");
      int[] parsedNumbers = new int[stringNumbers.length];

      for (int i = 0; i < stringNumbers.length; i++) {
        parsedNumbers[i] = Integer.parseInt(stringNumbers[i].trim());
      }

      return parsedNumbers;
    }
  }


