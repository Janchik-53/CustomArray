package com.reiba.ft.factory;
import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.factory.impl.AbstractArrayFactory;
import com.reiba.ft.util.IdGenerator;

public class IntArrayFactory implements AbstractArrayFactory {

  @Override
  public IntArray createInt(int[] data) throws CustomException {
    return new IntArray(IdGenerator.incrementId(), data);
  }
}
