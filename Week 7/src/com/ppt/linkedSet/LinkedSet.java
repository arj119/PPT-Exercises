package com.ppt.linkedSet;

import com.ppt.ConcurrentSet;

import java.util.List;

public class LinkedSet<E> implements ConcurrentSet<E> {
  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public boolean add(E e) {
    return false;
  }

  @Override
  public List<E> toList() {
    return null;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }
}
