package com.reiba.ft.warehouse;

import java.util.HashMap;
import java.util.Map;

public final class ArrayWarehouse {

  private static final ArrayWarehouse INSTANCE = new ArrayWarehouse();

  private final Map<Long, ArrayStatistics> statisticsById = new HashMap<>();

  private ArrayWarehouse() {
  }

  public static ArrayWarehouse getInstance() {
    return INSTANCE;
  }

  public void put(long arrayId, ArrayStatistics statistics) {
    statisticsById.put(arrayId, statistics);
  }

  public ArrayStatistics get(long arrayId) {
    return statisticsById.get(arrayId);
  }

  public void remove(long arrayId) {
    statisticsById.remove(arrayId);
  }

  public void clear() {
    statisticsById.clear();
  }
}

