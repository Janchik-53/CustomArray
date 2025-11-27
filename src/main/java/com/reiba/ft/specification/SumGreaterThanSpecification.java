package com.reiba.ft.specification;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.warehouse.ArrayStatistics;
import com.reiba.ft.warehouse.ArrayWarehouse;

public class SumGreaterThanSpecification implements ArraySpecification {

  private final int threshold;
  private final ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

  public SumGreaterThanSpecification(int threshold) {
    this.threshold = threshold;
  }

  @Override
  public boolean match(IntArray array) {
    if (array == null) {
      return false;
    }
    ArrayStatistics statistics = warehouse.get(array.getId());
    if (statistics == null) {
      return false;
    }
    return statistics.getSum() > threshold;
  }
}
