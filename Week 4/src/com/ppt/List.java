package com.ppt;


/**
 * Number - superclass
 * Integer, Double, Float, BigInteger... Numeric types
 * 
 * An interface for a list that holds integers
 */
public interface List<T> {
  /**
   * Returns the size of the list
   *
   * @return size of the list
   */
  int size();

  /**
   * Returns when the list is empty
   *
   * @return whether list is empty
   */
  boolean isEmpty();

  /**
   * Searches the list for a given element
   *
   * @param n element to be found
   * @return index in list. If not found in list returns -1
   */
  int indexOf(T n);

  /**
   * Checks whether list contains element
   *
   * @param n element to search for
   * @return true if the element is in the list
   */
  boolean contains(T n);

  /**
   * Adds an element to the end of the list
   *
   * @param n element to be added
   */
  void add(T n);

  /**
   * Removes the first occurence of an element from the list
   *
   * @param n element to be removed
   * @return true if the element was found and successfully removed
   */
  boolean remove(T n);

  /** Clears the list of all elements */
  void clear();

  /**
   * Gets the element at index. If index is not in bounds throw an IllegalArgumentException
   *
   * @param index position of element in the list
   * @return element in the list at index
   */
  int get(int index);

  /**
   * Inserts an element at the given index. If the index is too large insert at the end of the list.
   * throws an error when the index given is negative.
   *
   * @param index position in the list to which the element is inserted
   * @param n element to be inserted
   */
  void insert(int index, T n);
}
