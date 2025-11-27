package com.reiba.ft.io;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.factory.impl.ArrayFactory;
import com.reiba.ft.parser.ArrayParserImpl;
import com.reiba.ft.parser.impl.ArrayParser;
import com.reiba.ft.validation.impl.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayFileReader {

  private static final Logger logger = LogManager.getLogger(ArrayFileReader.class);

  private final ArrayFactory arrayFactory;
  private final Validator lineValidator;
  private final ArrayParser lineParser;

  public ArrayFileReader(ArrayFactory arrayFactory, Validator lineValidator) {
    this(arrayFactory, lineValidator, new ArrayParserImpl());
  }

  public ArrayFileReader(ArrayFactory arrayFactory,
                         Validator lineValidator,
                         ArrayParser lineParser) {
    this.arrayFactory = arrayFactory;
    this.lineValidator = lineValidator;
    this.lineParser = lineParser;
  }

  public List<IntArray> read(Path filePath) throws CustomException {
    if (filePath == null) {
      throw new CustomException("filePath is null");
    }
    if (!Files.exists(filePath)) {
      throw new CustomException("file not found: " + filePath);
    }

    List<IntArray> parsedArrays = new ArrayList<>();

    try (Stream<String> fileLines =
                 Files.lines(filePath, StandardCharsets.UTF_8)) {

      final int[] currentLineNumber = {0};

      fileLines.forEach(rawLine -> {
        int lineNumber = ++currentLineNumber[0];
        String trimmedLine = rawLine == null ? "" : rawLine.trim();

        if (!lineValidator.isValid(trimmedLine)) {
          logger.warn("Line {} skipped as invalid: {}", lineNumber, rawLine);
          return;
        }

        int[] parsedNumbers = lineParser.parse(trimmedLine);

        try {
          IntArray arrayObject = arrayFactory.createInt(parsedNumbers);
          parsedArrays.add(arrayObject);
        } catch (CustomException creationError) {
          logger.error(
                  "Failed to create array on line {}: {}",
                  lineNumber,
                  creationError.getMessage()
          );
        }
      });

    } catch (IOException ioError) {
      throw new CustomException("error reading file: " + ioError.getMessage());
    }

    logger.info("Successfully read {} arrays from {}", parsedArrays.size(), filePath);
    return parsedArrays;
  }
}
