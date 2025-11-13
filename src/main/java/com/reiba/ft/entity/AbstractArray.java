package com.reiba.ft.entity;
import com.reiba.ft.exception.CustomException;

public abstract class AbstractArray {
  protected long arrayID;
  protected int[] data ;

  public long getId(){
    return arrayID;
  }

  protected AbstractArray(long id) {
    this.arrayID = id;
  }

  public long getID() {
    return arrayID;
  }

}
