package com.reiba.ft.service;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import java.util.function.IntPredicate;

public interface ArrayOperationsService {
  int sum(IntArray arr) throws CustomException;
  double average(IntArray arr) throws CustomException;
  int min(IntArray arr) throws CustomException;
  int max(IntArray arr) throws CustomException;
  long countPositive(IntArray arr) throws CustomException;
  long countNegative(IntArray arr) throws CustomException;
  void replaceIf(IntArray arr, IntPredicate cond, int newVal) throws CustomException;
}

