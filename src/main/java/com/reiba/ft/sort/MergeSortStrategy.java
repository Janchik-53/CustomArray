package com.reiba.ft.sort;

import com.reiba.ft.sort.impl.SortStrategy;

public class MergeSortStrategy implements SortStrategy {

  @Override
  public void sort(int[] array) {
    if (array == null || array.length < 2) {
      return;
    }
    int[] buffer = new int[array.length];
    mergeSort(array, buffer, 0, array.length - 1);
  }

  private void mergeSort(int[] array, int[] buffer, int leftIndex, int rightIndex) {
    if (leftIndex >= rightIndex) {
      return;
    }

    int middleIndex = (leftIndex + rightIndex) >>> 1;

    mergeSort(array, buffer, leftIndex, middleIndex);
    mergeSort(array, buffer, middleIndex + 1, rightIndex);

    int leftPointer = leftIndex;
    int rightPointer = middleIndex + 1;
    int bufferIndex = leftIndex;

    while (leftPointer <= middleIndex && rightPointer <= rightIndex) {
      if (array[leftPointer] <= array[rightPointer]) {
        buffer[bufferIndex++] = array[leftPointer++];
      } else {
        buffer[bufferIndex++] = array[rightPointer++];
      }
    }

    while (leftPointer <= middleIndex) {
      buffer[bufferIndex++] = array[leftPointer++];
    }

    while (rightPointer <= rightIndex) {
      buffer[bufferIndex++] = array[rightPointer++];
    }

    for (int index = leftIndex; index <= rightIndex; index++) {
      array[index] = buffer[index];
    }
  }
}

