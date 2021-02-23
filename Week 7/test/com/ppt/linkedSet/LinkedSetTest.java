package com.ppt.linkedSet;

import com.ppt.ConcurrentSetTest;

class LinkedSetTest extends ConcurrentSetTest<LinkedSet<Integer>> {

  @Override
  protected LinkedSet<Integer> createInstance() {
    return new LinkedSet<>();
  }
}
