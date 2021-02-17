package com.ppt.part1;

public class Main {

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Chopstick[] chopsticks = new Chopstick[philosophers.length];

        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        for (int i = 0; i < philosophers.length; i++) {
            // Create 5 philosopher's and assign their left and write chopsticks
            Chopstick leftChopstick = chopsticks[i];
            Chopstick rightChopstick = chopsticks[(i + 1) % chopsticks.length];

            philosophers[i] = new Philosopher(leftChopstick, rightChopstick);

            Thread t
                = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
