package com.ppt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public abstract class ConcurrentSetTest<T extends ConcurrentSet<Integer>> {

  private T set;

  protected abstract T createInstance();

  @BeforeEach
  public void setUp() {
    set = createInstance();
  }

  @Test
  void setIsEmptyWhenInitialised() {
    assertTrue(set.isEmpty());
    assertEquals(set.size(), 0);
  }

  @Test
  void canAddToSet() {
    set.add(2);
    assertEquals(1, set.size());
    assertTrue(set.contains(2));
  }

  @Test
  void duplicatesAreNotAdded() {
    assertTrue(set.add(2));
    assertFalse(set.add(2));
  }

  @Test
  void containsReturnsTheCorrectValue() {
    set.add(2);
    set.add(4);
    set.add(0);
    assertTrue(set.contains(0));
    assertTrue(set.contains(2));
    assertTrue(set.contains(4));
    assertFalse(set.contains(-2));
  }
  @Test
  void removalFromSetWorks() {
    set.add(2);
    assertTrue(set.contains(2));
    assertTrue(set.remove(2));
    assertFalse(set.contains(2));
  }
}