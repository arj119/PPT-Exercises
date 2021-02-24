package com.ppt.binarySearchTreeSet;

import com.ppt.ConcurrentSetTest;

class UnsafeBinarySearchTreeSetTest extends ConcurrentSetTest<UnsafeBinarySearchTreeSet<Integer>> {

  @Override
  protected UnsafeBinarySearchTreeSet<Integer> createInstance() {
    return new UnsafeBinarySearchTreeSet<>();
  }
}