package com.reiba.ft.service;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.service.impl.ArrayOperationsService;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ArrayOperationsServiceImpl implements ArrayOperationsService {

  @Override
  public int sum(IntArray array) throws CustomException {
    validate(array);
    int[] data = array.getData();
    IntStream stream = IntStream.of(data);
    return stream.sum();
  }

  @Override
  public double average(IntArray array) throws CustomException {
    validate(array);
    if (array.length() == 0) {
      throw new CustomException("array is empty");
    }
    int[] data = array.getData();
    IntStream stream = IntStream.of(data);
    return stream
            .average()
            .orElseThrow(() -> new CustomException("array is empty"));
  }

  @Override
  public int min(IntArray array) throws CustomException {
    validate(array);
    int[] data = array.getData();
    IntStream stream = IntStream.of(data);
    return stream
            .min()
            .orElseThrow(() -> new CustomException("array is empty"));
  }

  @Override
  public int max(IntArray array) throws CustomException {
    validate(array);
    int[] data = array.getData();
    IntStream stream = IntStream.of(data);
    return stream
            .max()
            .orElseThrow(() -> new CustomException("array is empty"));
  }

  @Override
  public long countPositive(IntArray array) throws CustomException {
    validate(array);
    int[] data = array.getData();
    IntStream stream = IntStream.of(data);
    return stream
            .filter(value -> value > 0)
            .count();
  }

  @Override
  public long countNegative(IntArray array) throws CustomException {
    validate(array);
    int[] data = array.getData();
    IntStream stream = IntStream.of(data);
    return stream
            .filter(value -> value < 0)
            .count();
  }

  @Override
  public void replaceIf(IntArray array,
                        IntPredicate condition,
                        int newValue) throws CustomException {
    validate(array);

    int[] originalValues = array.getData();
    for (int i = 0; i < originalValues.length; i++) {
      int currentValue = originalValues[i];
      if (condition.test(currentValue)) {
        originalValues[i] = newValue;
      }
    }

    array.setData(originalValues);
  }

  private static void validate(IntArray array) throws CustomException {
    if (array == null) {
      throw new CustomException("array is null");
    }
  }
}
