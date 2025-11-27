package com.reiba.ft.comparator;

import com.reiba.ft.entity.IntArray;
import java.util.Comparator;

public class FirstElementComparator implements Comparator<IntArray> {

  @Override
  public int compare(IntArray first, IntArray second) {
    int[] firstData = first.getData();
    int[] secondData = second.getData();

    int firstValue = firstData.length == 0 ? 0 : firstData[0];
    int secondValue = secondData.length == 0 ? 0 : secondData[0];

    return Integer.compare(firstValue, secondValue);
  }
}
