package com.ppt;

public interface ConcurrentSet<E> {
  /**
   * Returns the number of elements in this set (its cardinality).  If this
   * set contains more than Integer.MAX_VALUE elements, returns
   * Integer.MAX_VALUE.
   *
   * @return the number of elements in this set (its cardinality)
   */
  int size();

  /**
   * Returns true if this set contains no elements.
   *
   * @return true if this set contains no elements
   */
  boolean isEmpty();

  /**
   * Returns true if this set contains the specified element.
   * More formally, returns true if and only if this set
   * contains an element e such that Objects.equals(o, e).
   *
   * @param o element whose presence in this set is to be tested
   * @return true if this set contains the specified element
   */
  boolean contains(E o);


  // Modification Operations

  /**
   * Adds the specified element to this set if it is not already present
   * (optional operation).  More formally, adds the specified element
   * e to this set if the set contains no element e2
   * such that
   * Objects.equals(e, e2).
   * If this set already contains the element, the call leaves the set
   * unchanged and returns false.  In combination with the
   * restriction on constructors, this ensures that sets never contain
   * duplicate elements.
   *
   * @param e element to be added to this set
   * @return true if this set did not already contain the specified
   *         element
   */
  boolean add(E e);


  /**
   * Removes the specified element from this set if it is present
   * (optional operation).  More formally, removes an element e
   * such that
   * Objects.equals(o, e), if
   * this set contains such an element.  Returns true if this set
   * contained the element (or equivalently, if this set changed as a
   * result of the call).  (This set will not contain the element once the
   * call returns.)
   *
   * @param o object to be removed from this set, if present
   * @return true if this set contained the specified element
   */
  boolean remove(E o);

}
