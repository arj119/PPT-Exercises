package com.ppt.part2;

public class Incrementer implements Runnable {

  private final Counter counter;

  public Incrementer(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 20; i++) {
        int count = counter.increment();
        doAction("Incrementing counter value: " + count);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private void doAction(String action) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " " + action);
    Thread.sleep(100);
  }
}
