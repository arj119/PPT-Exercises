package com.ppt.binarySearchTreeSet;

import com.ppt.ConcurrentSetTest;

class CoarseBinarySearchTreeSetTest extends ConcurrentSetTest<CoarseBinarySearchTreeSet<Integer>> {

  @Override
  protected CoarseBinarySearchTreeSet<Integer> createInstance() {
    return new CoarseBinarySearchTreeSet<>();
  }
}
