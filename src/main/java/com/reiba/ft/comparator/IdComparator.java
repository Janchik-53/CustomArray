package com.reiba.ft.comparator;

import com.reiba.ft.entity.IntArray;
import java.util.Comparator;

public class IdComparator implements Comparator<IntArray> {

  @Override
  public int compare(IntArray first, IntArray second) {
    long firstId = first.getId();
    long secondId = second.getId();
    return Long.compare(firstId, secondId);
  }
}


