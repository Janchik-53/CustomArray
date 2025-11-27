package com.reiba.ft.warehouse;

public class ArrayStatistics {

  private final int sum;
  private final double average;
  private final int min;
  private final int max;
  private final long positiveCount;
  private final long negativeCount;

  public ArrayStatistics(int sum, double average, int min, int max, long positiveCount, long negativeCount) {
    this.sum = sum;
    this.average = average;
    this.min = min;
    this.max = max;
    this.positiveCount = positiveCount;
    this.negativeCount = negativeCount;
  }

  public int getSum() {
    return sum;
  }

  public double getAverage() {
    return average;
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  public long getPositiveCount() {
    return positiveCount;
  }

  public long getNegativeCount() {
    return negativeCount;
  }
}
