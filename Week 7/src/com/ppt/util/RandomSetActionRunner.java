package com.ppt.util;

import com.ppt.ConcurrentSet;

import java.util.*;

public class RandomSetActionRunner implements Runnable {

  private final ConcurrentSet<Integer> set;
  private final Iterator<Integer> numbersToAdd;
  private final Iterator<Integer> numbersToRemove;
  private final Iterator<Integer> numbersToCheckContains;
  private final int numActions;

  public RandomSetActionRunner(
      ConcurrentSet<Integer> set,
      List<Integer> numbersToAdd,
      List<Integer> numbersToRemove,
      List<Integer> numbersToCheckContains) {
    this.set = set;
    this.numbersToAdd = numbersToAdd.iterator();
    this.numbersToRemove = numbersToRemove.iterator();
    this.numbersToCheckContains = numbersToCheckContains.iterator();
    this.numActions = numbersToAdd.size() + numbersToRemove.size() + numbersToCheckContains.size();
  }

  @Override
  public void run() {
    Random gen = new Random();
    for (int i = 0; i < numActions; i++) {
      completeAction(ACTION.getRandomAction());
      try {
        Thread.sleep(gen.nextInt(50));
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }

  private void completeAction(ACTION action) {
    switch (action) {
      case ADD:
        if (numbersToAdd.hasNext()) {
          set.add( numbersToAdd.next());
          break;
        }
      case REMOVE:
        if (numbersToRemove.hasNext()) {
          set.remove(numbersToRemove.next());
          break;
        }
      case CHECK_CONTAINS:
        if (numbersToCheckContains.hasNext()) {
          set.contains(numbersToCheckContains.next());
          break;
        }
      default:
        completeAction(ACTION.getRandomAction());
    }
  }

  private enum ACTION {
    ADD,
    REMOVE,
    CHECK_CONTAINS;

    private static final Random GEN = new Random();

    private static ACTION getRandomAction() {
      ACTION[] actions = ACTION.values();
      return actions[GEN.nextInt(actions.length)];
    }
  }
}
