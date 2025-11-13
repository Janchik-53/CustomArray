package com.reiba.ft.sort;

public class QuickSortStrategy implements SortStrategy {
  @Override public void sort(int[] a) {
    if (a == null || a.length < 2) return;
    q(a, 0, a.length - 1);
  }
  private void q(int[] a, int l, int r) {
    int i=l, j=r, p=a[l+(r-l)/2];
    while (i<=j) {
      while (a[i]<p) i++;
      while (a[j]>p) j--;
      if (i<=j) { int t=a[i]; a[i]=a[j]; a[j]=t; i++; j--; }
    }
    if (l<j) q(a,l,j);
    if (i<r) q(a,i,r);
  }
}
