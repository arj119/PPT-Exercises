package com.ppt.util;

import com.ppt.ConcurrentSet;

import java.util.List;

public class AddRemoveSetRunner implements Runnable {
  private final ConcurrentSet<Integer> set;
  private final List<Integer> numbersToAdd;

  public AddRemoveSetRunner(ConcurrentSet<Integer> set, List<Integer> numbersToAddRemove) {
    this.set = set;
    this.numbersToAdd = numbersToAddRemove;
  }

  @Override
  public void run() {
    for (int num : numbersToAdd) {
      set.add(num);
      set.remove(num);
    }
  }
}
