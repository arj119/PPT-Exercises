package com.ppt.binarySearchTreeSet;

public class CoarseBinarySearchTreeSet<E extends Comparable<E>> extends BinarySearchTreeSet<E> {
  @Override
  protected boolean containsNodeRecursive(Node current, E value) {
    return super.containsNodeRecursive(current, value);
  }

  @Override
  protected Node addRecursive(Node current, E value) {
    return super.addRecursive(current, value);
  }

  @Override
  protected Node deleteNode(Node node) {
    return super.deleteNode(node);
  }

  @Override
  protected Node removeRecursive(Node current, E value) {
    return super.removeRecursive(current, value);
  }

  @Override
  protected E findSmallestValue(Node node) {
    return super.findSmallestValue(node);
  }

}
