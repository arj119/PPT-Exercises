package com.ppt;

import com.ppt.utils.RandomThoughts;

import java.util.Random;

public class Philosopher implements Runnable {
  private static final int MAX_WAITING_TIME_MS = 10;
  private static final Random GEN = new Random();
  private final Chopstick leftChopstick;
  private final Chopstick rightChopstick;

  public Philosopher(Chopstick leftChopstick, Chopstick rightChopstick) {
    this.leftChopstick = leftChopstick;
    this.rightChopstick = rightChopstick;
  }

  @Override
  public void run() {
    try {
      while (true) {
        think();
        synchronized (leftChopstick) {
          pick_up_left_chopstick();
          synchronized (rightChopstick) {
            pick_up_right_chopstick();
            eat();
            put_down_right_chopstick();
          }
          put_down_left_chopstick();
        }
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private void think() throws InterruptedException {
    doAction("Thinking... " + RandomThoughts.inspireTheMind());
  }

  private void eat() throws InterruptedException {
    doAction("Eating");
  }

  private void pick_up_left_chopstick() throws InterruptedException {
    doAction("Picking up left chopstick");
  }

  private void pick_up_right_chopstick() throws InterruptedException {
    doAction("Picking up right chopstick");
  }

  private void put_down_left_chopstick() throws InterruptedException {
    doAction("Putting down left chopstick");
  }

  private void put_down_right_chopstick() throws InterruptedException {
    doAction("Putting down right chopstick");
  }

  private void doAction(String action) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " " + action);
    Thread.sleep(GEN.nextInt(MAX_WAITING_TIME_MS));
  }
}
