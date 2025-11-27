package com.reiba.ft.specification;

import com.reiba.ft.entity.IntArray;

public class IdSpecification implements ArraySpecification {

  private final long requiredId;

  public IdSpecification(long requiredId) {
    this.requiredId = requiredId;
  }

  @Override
  public boolean match(IntArray array) {
    if (array == null) {
      return false;
    }
    return array.getId() == requiredId;
  }
}

