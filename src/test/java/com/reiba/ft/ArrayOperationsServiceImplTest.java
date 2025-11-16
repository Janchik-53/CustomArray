package com.reiba.ft;

import com.reiba.ft.entity.IntArray;
import com.reiba.ft.exception.CustomException;
import com.reiba.ft.service.ArrayOperationsService;
import com.reiba.ft.service.impl.ArrayOperationsServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOpsServiceImplTest {

  private ArrayOperationsService service;

  @BeforeEach
  void setUp() {
    service = new ArrayOperationsServiceImpl();
  }

  @AfterEach
  void tearDown() {
    service = null;
  }

  @Test
  void sumAndAverage() throws CustomException {
    IntArray arr = new IntArray(1L, new int[]{1, 2, 3, 4});
    assertEquals(10, service.sum(arr));
    assertEquals(2.5, service.average(arr));
  }

  @Test
  void minAndMax() throws CustomException {
    IntArray arr = new IntArray(1L, new int[]{5, -2, 7, 0});
    assertEquals(-2, service.min(arr));
    assertEquals(7, service.max(arr));
  }

  @Test
  void countPositiveAndNegative() throws CustomException {
    IntArray arr = new IntArray(1L, new int[]{-3, -1, 0, 2, 5});
    assertEquals(2, service.countPositive(arr));
    assertEquals(2, service.countNegative(arr));
  }

  @Test
  void replaceIfWorks() throws CustomException {
    IntArray arr = new IntArray(1L, new int[]{-3, 1, -2, 4});
    service.replaceIf(arr, v -> v < 0, 0);
    assertArrayEquals(new int[]{0, 1, 0, 4}, arr.getData());
  }

  @Test
  void averageOnEmptyThrows() throws CustomException {
    IntArray empty = new IntArray(1L, new int[]{});
    CustomException ex = assertThrows(CustomException.class, () -> service.average(empty));
    assertTrue(ex.getMessage().toLowerCase().contains("empty"));
  }
}
