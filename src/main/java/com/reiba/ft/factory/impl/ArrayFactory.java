package com.reiba.ft.factory.impl;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;

public interface ArrayFactory {
  IntArray createInt(int[] data) throws CustomException;
}


