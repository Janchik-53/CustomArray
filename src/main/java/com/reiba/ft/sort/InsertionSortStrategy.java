package com.reiba.ft.sort;
import com.reiba.ft.sort.impl.SortStrategy;

public class InsertionSortStrategy implements SortStrategy {

  @Override
  public void sort(int[] array) {
    if (array == null || array.length < 2) {
      return;
    }

    for (int i = 1; i < array.length; i++) {
      int key = array[i];
      int j = i - 1;

      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j--;
      }

      array[j + 1] = key;
    }
  }
}
