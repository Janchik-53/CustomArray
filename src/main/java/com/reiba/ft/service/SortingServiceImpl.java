package com.reiba.ft.service;

import com.reiba.ft.sort.SortRegistry;
import com.reiba.ft.sort.impl.SortStrategy;
import com.reiba.ft.service.impl.SortingService;

public class SortingServiceImpl implements SortingService {

  private final SortRegistry registry = new SortRegistry();

  @Override
  public int[] sortCopy(int[] source, String algorithmName) {
    int[] copy = copyOf(source);
    SortStrategy strategy = registry.get(algorithmName);
    if (strategy != null) {
      strategy.sort(copy);
    }
    return copy;
  }

  private static int[] copyOf(int[] source) {
    int[] result = new int[source.length];
    for (int i = 0; i < source.length; i++) {
      result[i] = source[i];
    }
    return result;
  }
}
