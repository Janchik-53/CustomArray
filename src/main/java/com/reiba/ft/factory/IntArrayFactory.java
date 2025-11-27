package com.reiba.ft.factory;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.factory.impl.ArrayFactory;
import com.reiba.ft.repository.IntArrayRepository;
import com.reiba.ft.util.IdGenerator;

public class IntArrayFactory implements ArrayFactory {

  private final IntArrayRepository repository = IntArrayRepository.getInstance();

  @Override
  public IntArray createInt(int[] data) throws CustomException {
    long id = IdGenerator.incrementId();
    IntArray array = new IntArray(id, data);
    repository.add(array);
    return array;
  }
}
