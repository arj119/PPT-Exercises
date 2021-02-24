package com.ppt.binarySearchTreeSet;

import com.ppt.ConcurrentSet;

import java.util.ArrayList;
import java.util.List;

public abstract class BinarySearchTreeSet<E extends Comparable<E>> implements ConcurrentSet<E> {
  protected int size = 0;
  protected Node root = null;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(E o) {
    return containsNodeRecursive(root, o);
  }

  protected boolean containsNodeRecursive(Node current, E value) {
    if (current == null) {
      // end of a branch
      return false;
    }

    if (value.equals(current.data)) {
      // found the value
      return true;
    }

    // if value is less than current node's data check left subtree otherwise right
    return value.compareTo(current.data) < 0
        ? containsNodeRecursive(current.left, value)
        : containsNodeRecursive(current.right, value);
  }

  @Override
  public boolean add(E e) {
    // duplicate check
    if (contains(e)) return false;

    if (isEmpty()) {
      // empty case
      root = new Node(e);
    } else {
      addRecursive(root, e);
    }
    size++;
    return true;
  }

  protected Node addRecursive(Node current, E value) {
    if (current == null) {
      // end of branch is reached
      return new Node(value);
    }

    if (value.compareTo(current.data) < 0) {
      // value < current.data
      current.left = addRecursive(current.left, value);
    } else if (value.compareTo(current.data) > 0) {
      // value > current.data
      current.right = addRecursive(current.right, value);
    } else {
      // value already exists
      return current;
    }

    return current;
  }

  @Override
  public boolean remove(E o) {
    // Set is empty or does not contain element
    if (isEmpty() || !contains(o)) return false;

    // Set is of size 1
    if (size() == 1) {
      root = null;
    } else {
      removeRecursive(root, o);
    }

    size--;
    return true;
  }

  protected Node removeRecursive(Node current, E value) {
    if (current == null) {
      return null;
    }

    if (value.equals(current.data)) {
      // Node to delete found
      return deleteNode(current);
    }

    // Search subtrees
    if (value.compareTo(current.data) < 0) {
      // Recurse into left subtree
      current.left = removeRecursive(current.left, value);
    } else {
      // Recurse into right subtree
      current.right = removeRecursive(current.right, value);
    }

    return current;
  }

  protected Node deleteNode(Node node) {
    // No children
    if (node.left == null && node.right == null) {
      return null;
    }

    // One child
    if (node.right == null) return node.left;
    if (node.left == null) return node.right;

    // Two children - replace node data with smallest child on the right subtree
    E smallestValue = findSmallestValue(node.right);
    node.data = smallestValue;
    node.right = removeRecursive(node.right, smallestValue);
    return node;
  }

  @Override
  public List<E> toList() {
    List<E> list = new ArrayList<>();
    toListRecursive(root, list);
    return list;
  }

  private void toListRecursive(Node current, List<E> list) {
    if(current == null) return;

    toListRecursive(current.left, list);
    list.add(current.data);
    toListRecursive(current.right, list);
  }

  protected E findSmallestValue(Node node) {
    return node.left == null ? node.data : findSmallestValue(node.left);
  }

  protected class Node {
    E data;
    Node left;
    Node right;

    Node(E data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
}
