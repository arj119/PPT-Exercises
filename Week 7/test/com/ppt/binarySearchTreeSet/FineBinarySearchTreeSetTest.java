package com.ppt.binarySearchTreeSet;

import com.ppt.ConcurrentSetTest;

class FineBinarySearchTreeSetTest extends ConcurrentSetTest<BinarySearchTreeSet<Integer>> {

  @Override
  protected BinarySearchTreeSet<Integer> createInstance() {
    return new FineBinarySearchTreeSet<>();
  }
}