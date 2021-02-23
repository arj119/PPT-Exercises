package com.ppt.binarySearchTreeSet;

import com.ppt.ConcurrentSetTest;

class UnsafeBinarySearchTreeSetTest extends ConcurrentSetTest<BinarySearchTreeSet<Integer>> {

  @Override
  protected BinarySearchTreeSet<Integer> createInstance() {
    return new UnsafeBinarySearchTreeSet<>();
  }
}