package org.howard.edu.lsp.assignment4.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.howard.edu.lsp.assignment4.implementation.IntegerSet;
import org.howard.edu.lsp.assignment4.implementation.IntegerSetException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * This class implements tests to verify the correct operation of the IntegerSet class
 * 
 * @author Ibukunoluwa Esan
 *
 */
class IntegerSetTest {

  static IntegerSet set1;
  static IntegerSet set2;

  @BeforeAll
  static void setUpClass() {
    set1 = new IntegerSet();
    set2 = new IntegerSet();
  }

  @BeforeEach
  void clearSets() {
    set1.clear();
    set2.clear();
  }

  @Test
  @DisplayName("Test cases for add")
  void testAdd() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    assertEquals(set1.toString(), "1 2 3");
    // Test duplicates
    set1.add(1);
    set1.add(4);
    assertEquals(set1.toString(), "1 2 3 4");
    // Test negatives
    set1.add(-1);
    set1.add(-5);
    assertEquals(set1.toString(), "1 2 3 4 -1 -5");
    // By design, non integer values cannot be passed to this function
  }

  @Test
  @DisplayName("Test cases for remove")
  void testRemove() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    assertEquals(set1.toString(), "1 2 3");
    set1.remove(1);
    set1.add(4);
    assertEquals(set1.toString(), "2 3 4");
    // Remove non-existent element
    set1.remove(35);
    set1.remove(58);
    assertEquals(set1.toString(), "2 3 4");

  }

  @Test
  @DisplayName("Test cases for clear")
  void testClear() {
    set1.add(10);
    set1.add(20);
    set1.add(30);
    set1.clear();
    assertEquals(set1.toString(), "");
  }

  @Test
  @DisplayName("Test cases for length")
  void testLength() {
    set1.add(1);
    set1.add(1000);
    set1.add(80);
    assertEquals(set1.length(), 3);
    set1.add(55);
    // Add duplicate
    set1.add(80);
    assertEquals(set1.length(), 4);
    set1.add(90);
    assertEquals(set1.length(), 5);
  }

  @Test
  @DisplayName("Test cases for equals")
  void testEquals() {
    set1.add(1);
    set1.add(90);
    set1.add(-1000);
    set2.add(1);
    set2.add(90);
    set2.add(-1000);
    assertTrue(set1.equals(set2));
    assertTrue(set2.equals(set1));
    // What if only one element is missing
    set1.remove(90);
    assertFalse(set1.equals(set2));
    assertFalse(set2.equals(set1));
    // should be commutative
    assertEquals(set1.equals(set2), set2.equals(set1));

  }

  @Test
  @DisplayName("Test cases for contains")
  void testContains() {
    set1.add(1);
    set1.add(90);
    set1.add(-1000);
    assertTrue(set1.contains(1));
    assertTrue(set1.contains(90));
    assertTrue(set1.contains(-1000));
    set1.remove(90);
    assertFalse(set1.contains(90));
    assertFalse(set1.contains(35));
  }

  @Test
  @DisplayName("Test cases for largest")
  void testLargest() throws IntegerSetException {

    assertThrows(IntegerSetException.class, () -> set1.largest());

    set1.add(50);
    assertEquals(set1.largest(), 50);
    set1.add(51);
    assertEquals(set1.largest(), 51);
    set1.add(-1);
    assertEquals(set1.largest(), 51);
  }

  @Test
  @DisplayName("Test cases for smallest")
  void testSmallest() throws IntegerSetException {

    assertThrows(IntegerSetException.class, () -> set1.smallest());

    set1.add(10000);
    assertEquals(set1.smallest(), 10000);
    set1.add(50);
    assertEquals(set1.smallest(), 50);
    set1.add(-935);
    assertEquals(set1.smallest(), -935);
    set1.add(-934);
    set1.add(0);
    assertEquals(set1.smallest(), -935);
  }

  @Test
  @DisplayName("Test cases for union")
  void testUnion() {
    set1.add(5);
    set1.add(9);
    set1.add(2);
    set1.add(6);
    set2.add(8);
    set2.add(9);
    set2.add(1);
    set2.add(7);
    set2.add(4);
    set1.union(set2);
    assertTrue(set1.contains(8));
    assertTrue(set1.contains(9));
    assertTrue(set1.contains(1));
    assertTrue(set1.contains(7));
    assertTrue(set1.contains(4));
    assertEquals(set1.length(), 8);
    // Set 2 is still intact
    assertEquals(set2.length(), 5);
  }


  @Test
  @DisplayName("Test cases for intersect")
  void testIntersect() {
    set1.add(5);
    set1.add(9);
    set1.add(2);
    set1.add(6);
    set2.add(8);
    set2.add(9);
    set2.add(1);
    set2.add(7);
    set2.add(4);
    set2.add(5);
    set1.intersect(set2);
    assertTrue(set1.contains(9));
    assertTrue(set1.contains(5));
    assertEquals(set1.length(), 2);
    // Set 2 is still intact
    assertEquals(set2.length(), 6);
  }

  @Test
  @DisplayName("Test cases for diff")
  void testdiff() {
    set1.add(5);
    set1.add(9);
    set1.add(2);
    set1.add(6);
    set2.add(8);
    set2.add(9);
    set2.add(1);
    set2.add(7);
    set2.add(4);
    set2.add(5);
    set1.diff(set2);
    assertTrue(set1.contains(2));
    assertTrue(set1.contains(6));
    assertEquals(set1.length(), 2);
    // Set 2 is still intact
    assertEquals(set2.length(), 6);
  }

  @Test
  @DisplayName("Test cases for to string")
  void testToString() {
    assertEquals(set1.toString(), "");
    set1.add(-1);
    set1.add(-92);
    set1.add(99233455);
    set1.add(-99233456);
    set1.add(0);
    assertEquals(set1.toString(), "-1 -92 99233455 -99233456 0");
    set1.remove(99233455);
    set1.remove(0);
    assertEquals(set1.toString(), "-1 -92 -99233456");
    set1.clear();
    assertEquals(set1.toString(), "");
  }

  @Test
  @DisplayName("Test cases for is empty")
  void testIsEmpty() {
    assertTrue(set1.isEmpty());
    set1.add(1);
    set1.remove(5);
    assertFalse(set1.isEmpty());
    set1.remove(1);
    assertTrue(set1.isEmpty());
    set1.add(23);
    set1.add(58);
    set1.add(-223);
    assertFalse(set1.isEmpty());
    set1.clear();
    assertTrue(set1.isEmpty());
  }
}
