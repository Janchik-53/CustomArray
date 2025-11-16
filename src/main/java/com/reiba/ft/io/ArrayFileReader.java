package com.reiba.ft.io;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.factory.impl.AbstractArrayFactory;
import com.reiba.ft.validation.Validator;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Читает IntArray из .txt; некорректные строки валидатором — WARN и пропуск. */
public class ArrayFileReader {
  private static final Logger log = LogManager.getLogger(ArrayFileReader.class);

  private final AbstractArrayFactory factory;
  private final Validator validator;

  public ArrayFileReader(AbstractArrayFactory factory, Validator validator) {
    this.factory = factory;
    this.validator = validator;
  }

  public List<IntArray> read(Path path) throws CustomException {
    if (path == null) throw new CustomException("path is null");
    if (!Files.exists(path)) throw new CustomException("file not found: " + path);

    String fname = path.getFileName().toString();
    String ext = fname.contains(".") ? fname.substring(fname.lastIndexOf('.') + 1) : "";
    if (!"txt".equals(ext)) throw new CustomException("unsupported file extension: " + ext);

    List<IntArray> out = new ArrayList<>();
    try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
      final int[] no = {0};
      lines.forEach(line -> {
        int n = ++no[0];
        String trimmed = (line == null) ? "" : line.trim();
        if (!validator.isValid(trimmed)) {
          log.warn("Invalid line {} skipped: {}", n, line);
          return;
        }
        int[] data = parse(trimmed);
        try {
          out.add(factory.createInt(data));  // ← ИСПОЛЬЗУЕМ createInt(...)
        } catch (Exception e) {
          log.error("Cannot create array from line {}: {}", n, e.getMessage());
        }
      });
    } catch (IOException e) {
      throw new CustomException("error reading file: " + e.getMessage());
    }
    log.info("Read {} arrays from {}", out.size(), path);
    return out;
  }

  private static int[] parse(String s) {
    if (s.isEmpty()) return new int[0];
    String[] tokens = s.split("(,|;|\\s+|\\s*[–-]\\s+)");
    int[] a = new int[tokens.length];
    for (int i = 0; i < tokens.length; i++) a[i] = Integer.parseInt(tokens[i].trim());
    return a;
  }
}
