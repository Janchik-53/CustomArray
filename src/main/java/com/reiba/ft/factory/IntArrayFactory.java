package com.reiba.ft.factory;
import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.factory.impl.ArrayFactory;
import com.reiba.ft.util.IdGenerator;

public class IntArrayFactory implements ArrayFactory {

  @Override
  public IntArray createInt(int[] data) throws CustomException {
    return new IntArray(IdGenerator.incrementId(), data);
  }
}
