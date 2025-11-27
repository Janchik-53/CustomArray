package com.reiba.ft.entity;

import com.reiba.ft.exception.CustomException;
import com.reiba.ft.observer.ArrayObservable;
import com.reiba.ft.observer.ArrayObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArray extends AbstractArray implements ArrayObservable {

  private static final Logger LOGGER = LogManager.getLogger(IntArray.class);

  private final List<ArrayObserver> observers = new ArrayList<>();
  private int[] data;

  public IntArray(long id, int[] data) throws CustomException {
    super(id);
    if (data == null) {
      throw new CustomException("data is null");
    }
    this.data = Arrays.copyOf(data, data.length);
    LOGGER.debug("IntArray created id={}, len={}", id, data.length);
  }

  public int length() {
    return data.length;
  }

  public int[] getData() {
    return Arrays.copyOf(data, data.length);
  }

  public void setData(int[] newData) throws CustomException {
    if (newData == null) {
      throw new CustomException("newData is null");
    }
    this.data = Arrays.copyOf(newData, newData.length);
    LOGGER.debug("Data updated: id={}, len={}", arrayId, newData.length);
    notifyObservers();
  }

  @Override
  public void addObserver(ArrayObserver observer) {
    if (observer != null && !observers.contains(observer)) {
      observers.add(observer);
    }
  }

  @Override
  public void removeObserver(ArrayObserver observer) {
    observers.remove(observer);
  }

  private void notifyObservers() {
    for (ArrayObserver observer : observers) {
      observer.onArrayChanged(this);
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("IntArray{id=");
    builder.append(arrayId).append(", data=[");
    for (int i = 0; i < data.length; i++) {
      if (i > 0) {
        builder.append(", ");
      }
      builder.append(data[i]);
    }
    builder.append("]}");
    return builder.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    IntArray other = (IntArray) obj;
    return Arrays.equals(this.data, other.data);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(data);
  }
}
