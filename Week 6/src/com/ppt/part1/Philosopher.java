package com.ppt.part1;

import com.ppt.part1.utils.RandomThoughts;
import java.util.*;

import java.util.Random;

public class Philosopher implements Runnable {
  private static final int MAX_WAITING_TIME_MS = 10;
  private static final Random GEN = new Random();
  private final Chopstick fstChopstick;
  private final Chopstick sndChopstick;

  public Philosopher(Chopstick leftChopstick, Chopstick rightChopstick) {
    Chopstick[] chopsticks = { leftChopstick, rightChopstick };
    Arrays.sort(chopsticks, (c1, c2) -> c1.getId() - c2.getId());

    this.fstChopstick = chopsticks[0];
    this.sndChopstick = chopsticks[1];
  }

  @Override
  public void run() {
    try {
      while (true) {
        think();
        synchronized (fstChopstick) {
          pick_up_left_chopstick();
          synchronized (sndChopstick) {
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
