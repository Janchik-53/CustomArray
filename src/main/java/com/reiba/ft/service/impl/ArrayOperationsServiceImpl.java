package com.reiba.ft.service.impl;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.service.ArrayOperationsService;
import java.util.function.IntPredicate;

  public class ArrayOperationsServiceImpl implements ArrayOperationsService {

    @Override public int sum(IntArray arr) throws CustomException {
      check(arr); int s = 0; for (int v : arr.getData()) s += v; return s;
    }

    @Override public double average(IntArray arr) throws CustomException {
      check(arr); if (arr.length() == 0) throw new CustomException("array is empty");
      return (double) sum(arr) / arr.length();
    }

    @Override public int min(IntArray arr) throws CustomException {
      check(arr); int[] a = arr.getData();
      if (a.length == 0) throw new CustomException("array is empty");
      int m = a[0]; for (int i = 1; i < a.length; i++) if (a[i] < m) m = a[i];
      return m;
    }

    @Override public int max(IntArray arr) throws CustomException {
      check(arr); int[] a = arr.getData();
      if (a.length == 0) throw new CustomException("array is empty");
      int m = a[0]; for (int i = 1; i < a.length; i++) if (a[i] > m) m = a[i];
      return m;
    }

    @Override public long countPositive(IntArray arr) throws CustomException {
      check(arr); long c = 0; for (int v : arr.getData()) if (v > 0) c++; return c;
    }

    @Override public long countNegative(IntArray arr) throws CustomException {
      check(arr); long c = 0; for (int v : arr.getData()) if (v < 0) c++; return c;
    }

    @Override public void replaceIf(IntArray arr, IntPredicate cond, int newVal) throws CustomException {
      check(arr);
      int[] data = arr.getData();
      for (int i = 0; i < data.length; i++) if (cond.test(data[i])) data[i] = newVal;
      arr.setData(data);
    }

    private static void check(IntArray arr) throws CustomException {
      if (arr == null) throw new CustomException("array is null");
    }
  }


