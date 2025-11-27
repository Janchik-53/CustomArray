package com.reiba.ft.sort;

import com.reiba.ft.sort.impl.SortStrategy;

public class QuickSortStrategy implements SortStrategy {

  @Override
  public void sort(int[] array) {
    if (array == null || array.length < 2) {
      return;
    }
    quickSort(array, 0, array.length - 1);
  }

  private void quickSort(int[] array, int leftIndex, int rightIndex) {
    int i = leftIndex;
    int j = rightIndex;
    int pivot = array[leftIndex + (rightIndex - leftIndex) / 2];

    while (i <= j) {
      while (array[i] < pivot) {
        i++;
      }
      while (array[j] > pivot) {
        j--;
      }
      if (i <= j) {
        int temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
        i++;
        j--;
      }
    }

    if (leftIndex < j) {
      quickSort(array, leftIndex, j);
    }
    if (i < rightIndex) {
      quickSort(array, i, rightIndex);
    }
  }
}
