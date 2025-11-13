package com.reiba.ft.sort;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortRegistry {
  private final Map<String, SortStrategy> byName;

  public SortRegistry() {
    Map<String, SortStrategy> map = new HashMap<>();
    map.put("quick", new QuickSortStrategy());
    map.put("merge", new MergeSortStrategy());
    map.put("insertion", new InsertionSortStrategy());
    this.byName = Collections.unmodifiableMap(map);
  }

  public SortStrategy get(String name) {
    if (name == null) return null;
    return byName.get(name.toLowerCase());
  }
}
