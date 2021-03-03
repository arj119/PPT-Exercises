package com.ppt.part2;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
  private AtomicInteger count = new AtomicInteger(0);

  public int increment() {
    // ++count
    return count.incrementAndGet();
  }

  public int getCount() {
    return count.get();
  }
}
