package com.reiba.ft.sort;

import com.reiba.ft.sort.impl.SortStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortRegistry {

  private final Map<String, SortStrategy> strategiesByName;

  public SortRegistry() {
    Map<String, SortStrategy> strategyMap = new HashMap<>();
    strategyMap.put("quick", new QuickSortStrategy());
    strategyMap.put("merge", new MergeSortStrategy());
    strategyMap.put("insertion", new InsertionSortStrategy());
    this.strategiesByName = Collections.unmodifiableMap(strategyMap);
  }

  public SortStrategy get(String algorithmName) {
    if (algorithmName == null) {
      return null;
    }
    String normalizedName = algorithmName.toLowerCase();
    return strategiesByName.get(normalizedName);
  }
}
