package com.ppt;

public class LinkedList<T> implements List<T> {
  private Node head;
  private int size;
  private Node tail;

  public LinkedList(){
    this.head = null;
    this.size = 0; 
    this.tail = null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public int indexOf(T n) {
    int index = 0;
    Node current = head;

    while(current != null) {
      if(current.data.equals(n)) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  @Override
  public boolean contains(T n) {
    return indexOf(n) != -1;
  }

  @Override
  public void add(T n) {
    Node node = new Node(n);
    if(isEmpty()) {
      head = node;
      tail = node;
    } else {
    	tail.next = node;
      tail = node;
    }
    size++;
  }

  @Override
  public boolean remove(T n) {
    return false;
  }

  @Override
  public void clear() {

  }

  @Override
  public int get(int index) {
    return 0;
  }

  @Override
  public void insert(int index, T n) {

  }

  private class Node {
    final T data;
    Node next;

    public Node (T data){
      this.data = data;
      this.next = null;
    }
  }
}
