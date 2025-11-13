package com.reiba.ft.factory;
import java.util.concurrent.atomic.AtomicLong;//for generating id
import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;

public class IntArrayFactory implements AbstractArrayFactory {
  private final AtomicLong seq = new AtomicLong(1);

  @Override
  public IntArray createInt(int[] data) throws CustomException {
    return new IntArray(seq.getAndIncrement(), data);
  }
}
