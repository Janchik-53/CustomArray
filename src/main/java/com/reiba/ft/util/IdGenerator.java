package com.reiba.ft.util;

public final class IdGenerator {
  private static long currentId = 0;

  private IdGenerator() {}

  public static long incrementId() {
    currentId++;
    return currentId;
  }
}
