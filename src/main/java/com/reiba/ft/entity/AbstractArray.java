package com.reiba.ft.entity;
import com.reiba.ft.exception.CustomException;

public abstract class AbstractArray {
  protected long arrayId;

  protected AbstractArray(long id) {
    this.arrayId = id;
  }

  public long getId() {
    return arrayId;
  }

}
