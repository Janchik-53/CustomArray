package com.reiba.ft.entity;
import com.reiba.ft.exception.CustomException;

public abstract class AbstractArray {
  protected long arrayId;

  public long getId(){
    return arrayId;
  }

  protected AbstractArray(long id) {
    this.arrayId = id;
  }

  public long getID() {
    return arrayId;
  }

}
