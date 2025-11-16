package com.reiba.ft.factory.impl;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;

public abstract interface AbstractArrayFactory {
  IntArray createInt(int[] data) throws CustomException;
}


