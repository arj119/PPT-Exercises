package com.ppt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

  @Test
  void testSetWithConcurrency() throws InterruptedException, ExecutionException {
    int numThreads = 4;
    ExecutorService service = Executors.newFixedThreadPool(numThreads);

    /* Submit tasks to add and remove same number from set to executor service
      we expect all threads to be able to successfully remove what they have added.
    */
    List<Future<Boolean>> tasks = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      int finalI = i;
      tasks.add(
          service.submit(
              () -> {
                boolean successRemoving = true;
                for (int j = 0; j < 10; j++) {
                  set.add(finalI + j);
                  successRemoving &= set.remove(finalI + j);
                }
                return successRemoving;
              }));
    }

    // Wait for tasks to complete
    for (Future<Boolean> task : tasks) {
      task.get();
    }
    service.shutdown();
    assertEquals(0, set.size());
  }
}
