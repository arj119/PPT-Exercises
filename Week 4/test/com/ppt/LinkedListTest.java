package com.ppt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

  LinkedList<Integer> list = new LinkedList<>();

  @Test
  void addingElementsToListIncreasesSize() {
    assertEquals(0, list.size());

    list.add(1);
    list.add(2);

    assertEquals(2, list.size());
  }

  @Test
  void removingElementsFromListDecreasesSize() {
    list.add(1);
    list.add(2);

    assertEquals(2, list.size());

    list.remove(1);
    list.remove(2);

    assertEquals(0, list.size());
  }

  @Test
  void removingElementsFromListIsTrueWhenElementsAreContained() {
    list.add(1);
    list.add(2);

    assertTrue(list.remove(2));
    assertFalse(list.remove(3));
  }

  @Test
  void listIsEmptyWhenInitialised() {
    assertTrue(list.isEmpty());
  }

  @Test
  void listIsNotEmptyWhenItemsAdded() {
    list.add(1);
    assertFalse(list.isEmpty());
  }

  @Test
  void indexOfReturnsIndexWhenElementIsInList() {
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    assertEquals(0, list.indexOf(1));
    assertEquals(1, list.indexOf(2));
    assertEquals(2, list.indexOf(3));
    assertEquals(3, list.indexOf(4));
  }

  @Test
  void indexOfReturnsMinusOneWhenElementIsNotInList() {
    assertEquals(-1, list.indexOf(1));
  }

  @Test
  void containsReturnsCorrectResult() {
    list.add(1);

    assertTrue(list.contains(1));
    assertFalse(list.contains(2));
  }

  @Test
  void addingAnElementAddsItToTheEndOfTheList() {
    list.add(1);

    assertEquals(0, list.indexOf(1));
  }

  @Test
  void clearMakesListEmpty() {
    list.add(1);
    list.add(2);
    list.add(3);

    list.clear();

    assertTrue(list.isEmpty());
    assertFalse(list.contains(1));
    assertFalse(list.contains(2));
    assertFalse(list.contains(3));
  }

  @Test
  void gettingAnElementAtIndexLessThanSizeReturnsCorrectly() {
    list.add(1);
    list.add(2);
    list.add(3);

    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  void gettingAnElementAtIndexOutOfBoundsThrowsIllegalArgumentException() {
    list.add(1);
    list.add(2);
    list.add(3);

    Exception e = assertThrows(IllegalArgumentException.class, () -> list.get(-1));

    String expectedMessage = "Index is out of bounds";
    String actualMessage = e.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void insertingAnElementAtIndex() {
    list.add(1);
    list.add(2);
    list.add(3);

    list.insert(1, 4);
    assertEquals(4, list.get(1));
  }

  @Test
  void insertingAnElementAtIndexTooLargeWillJustAddToEndOfTheList() {
    list.add(1);
    list.add(2);
    list.add(3);

    list.insert(10, 4);
    assertEquals(4, list.get(3));
  }

  @Test
  void insertingAnElementIntoANegativeIndexWillThrowAnIllegalArgumentException() {
    list.add(1);
    list.add(2);
    list.add(3);

    Exception e = assertThrows(IllegalArgumentException.class, () -> list.insert(-1, 4));

    String expectedMessage = "Index cannot be negative";
    String actualMessage = e.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
