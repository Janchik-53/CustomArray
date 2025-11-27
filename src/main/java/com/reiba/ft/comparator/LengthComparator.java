package com.reiba.ft.comparator;

import com.reiba.ft.entity.IntArray;

import java.util.Comparator;

public class LengthComparator implements Comparator<IntArray> {

  @Override
  public int compare(IntArray first, IntArray second) {
    int firstLength = first.length();
    int secondLength = second.length();
    return Integer.compare(firstLength, secondLength);
  }
}
