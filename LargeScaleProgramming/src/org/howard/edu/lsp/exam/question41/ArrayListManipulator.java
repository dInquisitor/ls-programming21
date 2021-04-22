package org.howard.edu.lsp.exam.question41;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of a class that manipulates an integer array
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class ArrayListManipulator {
  /**
   * @param integers ArrayList of Integers
   * @return ArrayList of integers after zeroes have been remove
   */
  public ArrayList<Integer> removeZeroes(ArrayList<Integer> integers) {
    integers.removeAll(Collections.singletonList(0));
    return integers;
  }
}
