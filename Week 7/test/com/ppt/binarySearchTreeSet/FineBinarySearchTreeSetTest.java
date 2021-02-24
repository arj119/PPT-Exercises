package com.ppt.binarySearchTreeSet;

import com.ppt.ConcurrentSetTest;

class FineBinarySearchTreeSetTest extends ConcurrentSetTest<FineBinarySearchTreeSet<Integer>> {

  @Override
  protected FineBinarySearchTreeSet<Integer> createInstance() {
    return new FineBinarySearchTreeSet<>();
  }
}
