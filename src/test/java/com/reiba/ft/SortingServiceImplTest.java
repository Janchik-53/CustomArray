package com.reiba.ft;

import com.reiba.ft.service.impl.SortingService;
import com.reiba.ft.service.SortingServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingServiceImplTest {

  private final SortingService sorting = new SortingServiceImpl();

  private int[] unsorted() {
    return new int[]{5, 1, -2, 9, 0};
  }

  private int[] expected() {
    return new int[]{-2, 0, 1, 5, 9};
  }

  @Test
  void quickSortWorks() {
    int[] result = sorting.sortCopy(unsorted(), "quick");
    assertArrayEquals(expected(), result);
  }

  @Test
  void mergeSortWorks() {
    int[] result = sorting.sortCopy(unsorted(), "merge");
    assertArrayEquals(expected(), result);
  }

  @Test
  void insertionSortWorks() {
    int[] result = sorting.sortCopy(unsorted(), "insertion");
    assertArrayEquals(expected(), result);
  }

  @Test
  void unknownAlgorithmReturnsCopyUnchanged() {
    int[] src = unsorted();
    int[] result = sorting.sortCopy(src, "bubble"); // такого алгоритма нет

    // Массив такой же по содержимому
    assertArrayEquals(src, result);
    // Но это копия, а не тот же объект
    assertNotSame(src, result);
  }
}
