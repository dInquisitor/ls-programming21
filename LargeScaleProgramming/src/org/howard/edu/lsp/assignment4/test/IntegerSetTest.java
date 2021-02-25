package org.howard.edu.lsp.assignment4.test;

import org.howard.edu.lsp.assignment4.implementation.IntegerSet;
import org.howard.edu.lsp.assignment4.implementation.IntegerSetException;

/**
 * This class implements tests to verify the correct operation of the IntegerSet class
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class IntegerSetTest {
  /**
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println("Creating empty set 1 and 2...");
    IntegerSet s1 = new IntegerSet();
    IntegerSet s2 = new IntegerSet();
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nAdding 1, 2 and 3 to Set 1...");
    s1.add(1);
    s1.add(2);
    s1.add(3);
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nClearing Set 1 [testing clear()]...");
    s1.clear();
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nAdding 1, 2 and 3 to Set 1...");
    s1.add(1);
    s1.add(2);
    s1.add(3);
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nTesting length()...");
    System.out.println("Set 1 length: " + s1.length() + "\nSet 2 length: " + s2.length());
    System.out.println("\nTesting adding duplicates. Adding 1, 2 and 3 to Set 1 again...");
    s1.add(1);
    s1.add(2);
    s1.add(3);
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nTesting equals()...");
    System.out.println("Set 1 ?== Set 2: " + String.valueOf(s1.equals(s2)));
    System.out.println(
        "\nMaking them equal. Adding 3, 2 and 1 to Set 2 in that order. Order should not matter");
    s2.add(3);
    s2.add(2);
    s2.add(1);
    System.out.println("Set 1 ?== Set 2: " + String.valueOf(s1.equals(s2)));
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nTesting contains...");
    System.out.println("Set 1 contains 2: " + s1.contains(2));
    System.out.println("Set 2 contains 5: " + s1.contains(5));
    System.out.println("\nTesting largest and smallest...");
    try {
      System.out.println("Largest in Set 1: " + s1.largest());
      System.out.println("Smallest in Set 2: " + s2.smallest());
    } catch (IntegerSetException e) {
      e.printStackTrace();
    }

    System.out.println("\nTesting largest and smallest Exceptions. Clearing both sets...");
    s1.clear();
    s2.clear();
    try {
      System.out.println("Largest in Set 1: " + s1.largest());
    } catch (IntegerSetException e) {
      System.out.println("Error: " + e.getMessage());
    }

    try {
      System.out.println("Smallest in Set 2: " + s2.smallest());
    } catch (IntegerSetException e) {
      System.out.println("Error: " + e.getMessage());
    }
    System.out.println("\nAdding 5, 9, 2, 6 to Set 1 and 8, 9, 1, 7, 4 to Set 2...");
    s1.add(5);
    s1.add(9);
    s1.add(2);
    s1.add(6);
    s2.add(8);
    s2.add(9);
    s2.add(1);
    s2.add(7);
    s2.add(4);
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nTesting remove from set. Removing 1 and 15 from Set 2");
    s2.remove(1);
    s2.remove(15);
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nTesting Union...");
    s1.union(s2);
    System.out.println("Set 1 union Set 2...");
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nTesting Intersection...");
    s1.intersect(s2);
    System.out.println("Set 1 intersect Set 2...");
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nTesting Difference...");
    s1.diff(s2);
    System.out.println("Set 1 - Set 2...");
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());
    System.out.println("\nSet 2 - Set 1...");
    System.out.println("Set 1: " + s1.toString() + "\nSet 2: " + s2.toString());

    System.out.println("\n All tests pass.");
    // System.out.println(s1.toString());
  }
}
