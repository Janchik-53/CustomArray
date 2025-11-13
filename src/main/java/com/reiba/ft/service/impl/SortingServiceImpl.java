package com.reiba.ft.service.impl;

import com.reiba.ft.service.SortingService;
import com.reiba.ft.sort.SortRegistry;
import com.reiba.ft.sort.SortStrategy;

public class SortingServiceImpl implements SortingService {

  private final SortRegistry registry = new SortRegistry();

  @Override
  public int[] sortCopy(int[] src, String algorithmName) {
    int[] copy = copyOf(src);
    SortStrategy strategy = registry.get(algorithmName);
    if (strategy != null) {
      strategy.sort(copy);
    }
    return copy;
  }

  private static int[] copyOf(int[] src) {
    int[] out = new int[src.length];
    for (int i = 0; i < src.length; i++) {
      out[i] = src[i];
    }
    return out;
  }
}
