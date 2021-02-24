package com.ppt.util;

import com.ppt.ConcurrentSet;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class OrderedSetActionRunner implements Runnable{
  private final ConcurrentSet<Integer> set;
  private final List<Integer> numbersToAdd;
  private final List<Integer> numbersToRemove;
  private final List<Integer> numbersToCheckContains;
  private final Random gen;

  public OrderedSetActionRunner(
      ConcurrentSet<Integer> set,
      List<Integer> numbersToAdd,
      List<Integer> numbersToRemove,
      List<Integer> numbersToCheckContains) {
    this.set = set;
    this.numbersToAdd = numbersToAdd;
    this.numbersToRemove = numbersToRemove;
    this.numbersToCheckContains = numbersToCheckContains;
    this.gen = new Random();
  }

  @Override
  public void run() {
      doAction(numbersToAdd, set::add);
      doAction(numbersToRemove, set::remove);
      doAction(numbersToCheckContains, set::contains);
  }

  private void doAction(List<Integer> nums, Function<Integer, Boolean> action) {
    try {
      for(int num : nums) {
        action.apply(num);
          Thread.sleep(gen.nextInt(50));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }
}
