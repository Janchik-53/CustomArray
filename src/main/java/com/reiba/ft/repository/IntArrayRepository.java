package com.reiba.ft.repository;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.observer.ArrayObserver;
import com.reiba.ft.service.impl.ArrayOperationsService;
import com.reiba.ft.service.ArrayOperationsServiceImpl;
import com.reiba.ft.specification.ArraySpecification;
import com.reiba.ft.warehouse.ArrayStatistics;
import com.reiba.ft.warehouse.ArrayWarehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class IntArrayRepository implements ArrayObserver {

  private static final IntArrayRepository INSTANCE = new IntArrayRepository();

  private final List<IntArray> storage = new ArrayList<>();
  private final ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
  private final ArrayOperationsService operationsService =
          new ArrayOperationsServiceImpl();

  private IntArrayRepository() {
  }

  public static IntArrayRepository getInstance() {
    return INSTANCE;
  }

  // ---------- CRUD-операции над репозиторием ----------

  public void add(IntArray array) throws CustomException {
    if (array == null) {
      throw new CustomException("array is null");
    }
    if (!storage.contains(array)) {
      storage.add(array);
      array.addObserver(this);
      recalculateStatistics(array);
    }
  }

  public void remove(IntArray array) {
    if (array == null) {
      return;
    }
    if (storage.remove(array)) {
      array.removeObserver(this);
      warehouse.remove(array.getId());
    }
  }

  public List<IntArray> getAll() {
    return Collections.unmodifiableList(storage);
  }

  public List<IntArray> query(ArraySpecification specification) {
    List<IntArray> result = new ArrayList<>();
    for (IntArray array : storage) {
      if (specification.match(array)) {
        result.add(array);
      }
    }
    return result;
  }

  public List<IntArray> sort(Comparator<IntArray> comparator) {
    List<IntArray> sortedCopy = new ArrayList<>(storage);
    sortedCopy.sort(comparator);
    return sortedCopy;
  }

  @Override
  public void onArrayChanged(IntArray array) {
    try {
      recalculateStatistics(array);
    } catch (CustomException exception) {
    }
  }

  private void recalculateStatistics(IntArray array) throws CustomException {
    int sum = operationsService.sum(array);
    double average = operationsService.average(array);
    int min = operationsService.min(array);
    int max = operationsService.max(array);
    long positiveCount = operationsService.countPositive(array);
    long negativeCount = operationsService.countNegative(array);

    ArrayStatistics statistics = new ArrayStatistics(
            sum,
            average,
            min,
            max,
            positiveCount,
            negativeCount
    );

    warehouse.put(array.getId(), statistics);
  }

  public void clear() {
    for (IntArray array : storage) {
      array.removeObserver(this);
    }
    storage.clear();
  }
}
