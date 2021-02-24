package com.ppt;

import com.ppt.binarySearchTreeSet.UnsafeBinarySearchTreeSet;
import com.ppt.util.RandomSetActionRunner;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
  private static final Random GEN = new Random(42);

  public static void main(String[] args) {
    int numThreads = 5;
    ConcurrentSet<Integer> set = new UnsafeBinarySearchTreeSet<>();
    List<Thread> threads = new ArrayList<>();

    for (int i = 0; i < numThreads; i++) createSetActionRunner(set, threads);

    Instant start = Instant.now();
    for (Thread t : threads) {
      t.start();
    }

    for (Thread t : threads) {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
        t.interrupt();
      }
    }
    Instant end = Instant.now();

    System.out.println(set.toList().toString());
    System.out.println(Duration.between(start, end).toMillis());
  }

  private static void createSetActionRunner(ConcurrentSet<Integer> set, List<Thread> threads) {
    List<Integer> toAdd = generateRandomNumbers(100);
    List<Integer> toRemove = generateRandomNumbers(40);
    List<Integer> toCheckContains = generateRandomNumbers(10);
    Thread thread3 = new Thread(new RandomSetActionRunner(set, toAdd, toRemove, toCheckContains));
    threads.add(thread3);
  }

  private static List<Integer> generateRandomNumbers(int length) {
    List<Integer> numbers = new ArrayList<>(length);
    for (int i = 0; i < length; i++) {
      numbers.add(GEN.nextInt(length));
    }
    return numbers;
  }
}
