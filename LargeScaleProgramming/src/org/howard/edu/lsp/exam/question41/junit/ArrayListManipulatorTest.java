package org.howard.edu.lsp.exam.question41.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.howard.edu.lsp.exam.question41.ArrayListManipulator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class tests the ArrayListManipulatorClass for correctness
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class ArrayListManipulatorTest {
  /**
   * Tests removing all occurrences of 0 form an ArrayList
   */
  @Test
  @DisplayName("test cases for removeZeroes")
  void testRemove() {
    ArrayListManipulator manipulator = new ArrayListManipulator();
    List<Integer> newList =
        manipulator.removeZeroes(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 8, 13, 21)));
    assertTrue(newList.equals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 8, 13, 21))));

    List<Integer> newList1 =
        manipulator.removeZeroes(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 2, 3, 4)));
    assertTrue(newList1.equals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))));

    List<Integer> newList2 =
        manipulator.removeZeroes(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 0, 0, 0)));
    assertTrue(newList2.equals(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));

    List<Integer> newList3 = manipulator
        .removeZeroes(new ArrayList<Integer>(Arrays.asList(5, 0, 1, 5, 2, 0, 9, 1, 0, 0)));
    assertTrue(newList3.equals(new ArrayList<Integer>(Arrays.asList(5, 1, 5, 2, 9, 1))));

    List<Integer> newList4 =
        manipulator.removeZeroes(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)));
    assertTrue(newList4.equals(new ArrayList<Integer>(Arrays.asList())));

    List<Integer> newList5 = manipulator.removeZeroes(new ArrayList<Integer>(Arrays.asList()));
    assertTrue(newList5.equals(new ArrayList<Integer>(Arrays.asList())));

    List<Integer> newList6 =
        manipulator.removeZeroes(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 0, 8, 13, 21)));
    assertFalse(newList6.equals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 0, 8, 13, 21))));

  }
}
