package com.reiba.ft;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.factory.AbstractArrayFactory;
import com.reiba.ft.factory.IntArrayFactory;
import com.reiba.ft.io.ArrayFileReader;
import com.reiba.ft.validation.LineValidator;
import com.reiba.ft.validation.Validator;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFileReaderTest {

  @Test
  void readSkipsInvalidLinesAndParsesValid() throws IOException, CustomException {
    Path tmp = Files.createTempFile("arrays-test", ".txt");

    // valid:   "1; 2; 3"
    // invalid: "1; 2; x3; 6..5; 77"
    // valid:   ""           -> пустой массив
    // valid:   "-1 0 5"
    // invalid: "1y1 21 32"
    String content = String.join(System.lineSeparator(),
            "1; 2; 3",
            "1; 2; x3; 6..5; 77",
            "",
            "-1 0 5",
            "1y1 21 32"
    );

    Files.writeString(tmp, content, StandardCharsets.UTF_8);

    AbstractArrayFactory factory = new IntArrayFactory();
    Validator validator = new LineValidator();
    ArrayFileReader reader = new ArrayFileReader(factory, validator);

    List<IntArray> arrays = reader.read(tmp);

    // Ожидаем 3 массива: [1,2,3], [], [-1,0,5]
    assertEquals(3, arrays.size());
    assertArrayEquals(new int[]{1, 2, 3}, arrays.get(0).getData());
    assertEquals(0, arrays.get(1).length());
    assertArrayEquals(new int[]{-1, 0, 5}, arrays.get(2).getData());

    Files.deleteIfExists(tmp);
  }
}
