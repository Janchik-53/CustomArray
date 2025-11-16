package com.reiba.ft.entity;
import java.util.Arrays;
import com.reiba.ft.exception.CustomException;
import org.apache.logging.log4j.LogManager;// фабрика,которая создает логи
import org.apache.logging.log4j.Logger;//объект который пишет логи

public class IntArray extends AbstractArray {
  private static final Logger log = LogManager.getLogger(IntArray.class);//«Создай объект log, который умеет писать сообщения от имени класса IntArray.
  private int[] data;

  public IntArray(long id,int [] data) throws CustomException {
  super(id);
    if (data == null) throw new CustomException("data is null");
    this.data = Arrays.copyOf(data,data.length);
    log.debug("IntArray created id={}, len={}", id, data.length);
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
    this.data = Arrays.copyOf(newData,newData.length);
    log.debug("Data updated: len={}", newData.length);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("IntArray{id=").append(arrayId).append(", data=[");
    for (int i = 0; i < data.length; i++) {
      if (i > 0) {
        sb.append(", ");
      }
      sb.append(data[i]);
    }
    return sb.append("]}").toString();
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
