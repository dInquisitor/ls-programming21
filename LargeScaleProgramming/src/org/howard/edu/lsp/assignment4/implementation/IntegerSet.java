package org.howard.edu.lsp.assignment4.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * This class implements a set abstract data type that holds integers only
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class IntegerSet {
  // Hint: probably best to use an array list. You will need to do a little research
  private List<Integer> set = new ArrayList<Integer>();

  /**
   * Getter for internal representation of set
   * 
   * @return internal set representation of the abstract data type
   */
  public List<Integer> getSet() {
    return set;
  }

  /**
   * Clears the internal representation of the set
   * 
   */
  public void clear() {
    set.clear();
  };


  /**
   * Returns the length of the set
   * 
   * @return the number of integers in the set
   */
  public int length() {
    return set.size();
  }; // returns the length

  /*
   * 
   */

  /**
   * Returns true if the 2 sets are equal, false otherwise; Two sets are equal if they contain all
   * of the same values in ANY order.
   * 
   * @param b another IntegerSet instance
   * @return true if the two sets are equal and false otherwise
   */
  public boolean equals(IntegerSet b) {
    int count = 0;
    for (Integer item : b.getSet()) {
      if (set.contains(item)) {
        count++;
      }
    }
    return count == this.length();
  };

  /**
   * Returns true if the set contains the value, otherwise false
   * 
   * @param value integer to check for
   * @return true if integer is present in the set and false otherwise
   */
  public boolean contains(int value) {
    return set.contains(value);
  };

  /**
   * Returns the largest item in the set; Throws a IntegerSetException if the set is empty
   * 
   * @return the largest item in the set
   * @throws IntegerSetException if the set is empty
   */
  public int largest() throws IntegerSetException {
    if (this.length() == 0) {
      throw new IntegerSetException("The integer set is empty");
    }

    int maxVal = set.get(0);
    for (Integer item : set) {
      if (item > maxVal) {
        maxVal = item;
      }
    }

    return maxVal;
  };

  /**
   * Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
   * 
   * @return the smallest item in the set
   * @throws IntegerSetException if the set is empty
   */
  public int smallest() throws IntegerSetException {
    if (this.length() == 0) {
      throw new IntegerSetException("The integer set is empty");
    }

    int minVal = set.get(0);
    for (Integer item : set) {
      if (item < minVal) {
        minVal = item;
      }
    }

    return minVal;
  }

  /**
   * Adds an item to the set or does nothing it already there
   * 
   * @param item integer to be added to set
   */
  public void add(int item) {
    if (!set.contains(item)) {
      set.add(item);
    }
  }; // adds item to s or does nothing if it is in set


  /**
   * Removes an item from the set or does nothing if not there
   * 
   * @param item integer to be removed from the set
   */
  public void remove(int item) {
    set.remove(Integer.valueOf(item));
  };

  // Set union
  /**
   * Makes a union of two sets, modifies the set on which it is called
   * 
   * @param intSetb another IntegerSet instance
   */
  public void union(IntegerSet intSetb) {
    HashSet<Integer> intSet = new HashSet<Integer>();
    List<Integer> se = new ArrayList<Integer>();
    for (Integer item : set) {
      if (!intSet.contains(item)) {
        se.add(item);
        intSet.add(item);
      }
    }

    for (Integer item : intSetb.getSet()) {
      if (!intSet.contains(item)) {
        se.add(item);
        intSet.add(item);
      }
    }

    set.clear();
    for (Integer item : se) {
      set.add(item);
    }
  };

  // Set intersection
  /**
   * Makes an intersection of two sets, modifies the set on which it is called
   * 
   * @param intSetb another IntegerSet instance
   */
  public void intersect(IntegerSet intSetb) {
    List<Integer> se = new ArrayList<Integer>();
    for (Integer item : intSetb.getSet()) {
      if (set.contains(item)) {
        se.add(item);
      }
    }

    set.clear();
    for (Integer item : se) {
      set.add(item);
    }
  };

  // Set difference, i.e., s1 – s2
  /**
   * Computes the difference between two sets, modifies the set on which it is called
   * 
   * @param intSetb another IntegerSet instance
   */
  public void diff(IntegerSet intSetb) {
    List<Integer> se = new ArrayList<Integer>();
    for (Integer item : set) {
      if (!intSetb.getSet().contains(item)) {
        se.add(item);
      }
    }

    set.clear();
    for (Integer item : se) {
      set.add(item);
    }
  } // set difference, i.e. s1 - s2

  // Returns true if the set is empty, false otherwise
  /**
   * Checks if the set is empty
   * 
   * @return true if the set is empty, false otherwise
   */
  boolean isEmpty() {
    return this.length() == 0;
  }

  /**
   * Return String representation of the set
   * 
   * @return stringified set
   */
  public String toString() {
    List<String> se = new ArrayList<String>();
    for (Integer item : set) {
      se.add(String.valueOf(item));
    }
    return String.join(" ", se);
  }; // return String representation of your set
}
