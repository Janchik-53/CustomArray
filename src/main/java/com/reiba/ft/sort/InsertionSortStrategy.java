package com.reiba.ft.sort;

public class InsertionSortStrategy implements SortStrategy {
  @Override public void sort(int[] a) {
    if (a == null || a.length < 2) return;
    for (int i=1;i<a.length;i++){
      int key=a[i], j=i-1;
      while (j>=0 && a[j]>key){ a[j+1]=a[j]; j--; }
      a[j+1]=key;
    }
  }
}
