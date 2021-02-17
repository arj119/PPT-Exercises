package com.ppt.part2;

import java.util.*;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    int numThreads = 5;

    // Initialise counter
    Counter counter = new Counter();

    List<Thread> threads = new ArrayList<>();
    // Initialise threads and give it increment task
    for (int i = 0; i < numThreads; i++) {
      Thread t = new Thread(new Incrementer(counter));
      threads.add(t);
      t.start();
    }
    
    // Wait for threads to finish
    threads.forEach((t) -> {
      try {
        t.join();
      } catch (InterruptedException e) {
        System.out.println(e.getStackTrace());
      }
    });

    // Print final counter value
    System.out.println("Final counter value: " + counter.getCount());
    // Print expected counter value
    System.out.println("Expected: " + (20 * threads.size()));
  }
}
