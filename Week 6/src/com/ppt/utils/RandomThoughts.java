package com.ppt.utils;

import java.util.List;
import java.util.Random;

public class RandomThoughts {
  private static final Random RANDOM = new Random();
  private static final List<String> THOUGHTS = List.of(
      "If you put dirt in soap, is the soap dirty or the dirt clean?",
      "What is shrek?",
      "Would nutella and mushrooms taste good?",
      "This food is weird",
      "Why wouldn't they give us enough chopsticks? :(",
      "Why is everyone taking so long to eat",
      "No one is talking this is so antisocial...",
      "I wish I was at home",
      "I am getting McDonald's after this but what?",
      "How can delivery cost more than the food, is a £1.39 McFlurry really worth paying £3.50 for delivery for.",
      "C++ is annoying",
      "I hope we don't deadlock when deciding on who pays",
      "Am I even hungry?"
  );

  public static String inspireTheMind() {
    return THOUGHTS.get(RANDOM.nextInt(THOUGHTS.size()));
  }
}
