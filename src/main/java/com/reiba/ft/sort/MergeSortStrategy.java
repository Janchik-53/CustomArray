package com.reiba.ft.sort;

public class MergeSortStrategy implements SortStrategy {
  @Override public void sort(int[] a) {
    if (a == null || a.length < 2) return;
    int[] b = new int[a.length];
    m(a,b,0,a.length-1);
  }
  private void m(int[] a,int[] b,int l,int r){
    if(l>=r) return;
    int m=(l+r)>>>1;
    m(a,b,l,m); m(a,b,m+1,r);
    int i=l,j=m+1,k=l;
    while(i<=m && j<=r) b[k++]=(a[i]<=a[j])?a[i++]:a[j++];
    while(i<=m) b[k++]=a[i++];
    while(j<=r) b[k++]=a[j++];
    for(i=l;i<=r;i++) a[i]=b[i];
  }
}
