package com.ppt.binarySearchTreeSet;

import com.ppt.ConcurrentSetTest;

class CoarseBinarySearchTreeSetTest extends ConcurrentSetTest<BinarySearchTreeSet<Integer>> {

  @Override
  protected BinarySearchTreeSet<Integer> createInstance() {
    return new CoarseBinarySearchTreeSet<>();
  }
}