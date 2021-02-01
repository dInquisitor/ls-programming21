package org.howard.edu.lsp.assignment2.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.howard.edu.lsp.assignment2.combination.Solver;

/**
 * This class implements a testing system to verify the correctness of the results produced by the
 * solver class
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class Tester {

  /**
   * This method compares expected results for the combination problem with the answers from the
   * solver class
   * 
   * @param result - answer produced by solver class
   * @param answer - expected answer
   * @return true if result and answer correlates and false if not
   */
  private static boolean isCorrect(ArrayList<HashSet<Integer>> result, Integer[][] answer) {
    if (result.size() != answer.length) {
      return false;
    }

    // Check through the expected answer list and remove elements common to the generated answers
    // list
    for (Integer[] answerList : answer) {
      HashSet<Integer> answerSet = new HashSet<Integer>(Arrays.asList(answerList));
      if (!result.contains(answerSet)) {
        return false;
      }
      result.remove(answerSet);

    }
    return result.size() == 0;
  }

  /**
   * @param isCorrect - true if result from solver class and expected answer correlates and false if
   *        not
   * @return string Pass if isCorrect and Fail if not
   */
  private static String passOrFail(boolean isCorrect) {
    return isCorrect ? "Pass" : "Fail";
  }

  /**
   * Main method that runs the tests on the calculateCombinations method in the solver class
   * 
   * @param args - command line arguments
   */
  public static void main(String[] args) {
    Solver combination = new Solver();

    // Queries are input arrays and answers are expected results
    int[] query1 = {5, 5, 15, 10};
    Integer[][] answer1 = {{2}, {0, 3}, {1, 3}};

    int[] query2 = {1, 2, 3, 4, 5, 6};
    Integer[][] answer2 = {{0, 1, 2}, {1, 3}, {0, 4}, {5}};

    int[] query3 = {};
    Integer[][] answer3 = {};

    int[] query4 = {10, 20, 30, 50, 90, 100};
    Integer[][] answer4 = {{0, 1, 4}, {2, 4}, {1, 5}};

    int[] query5 = {-8, 15, 4, 9, -2};
    Integer[][] answer5 = {{2, 3}, {1, 4}};

    int[] query6 = {-6, -4, 8, -18, 10, -10};
    Integer[][] answer6 = {{5, 4, 3, 2}, {5, 4, 1, 0}, {5}, {4, 3, 2, 1, 0}, {3, 2}, {1, 0}};

    int[] query7 = {9, 9};
    Integer[][] answer7 = {};

    int[] query8 = {50, 50, -50};
    Integer[][] answer8 = {{0}, {1}, {0, 1, 2}};

    // Run tests
    ArrayList<HashSet<Integer>> result1 = combination.calculateCombinations(query1, 15);
    ArrayList<HashSet<Integer>> result2 = combination.calculateCombinations(query2, 6);
    ArrayList<HashSet<Integer>> result3 = combination.calculateCombinations(query3, 10);
    ArrayList<HashSet<Integer>> result4 = combination.calculateCombinations(query4, 120);
    ArrayList<HashSet<Integer>> result5 = combination.calculateCombinations(query5, 13);
    ArrayList<HashSet<Integer>> result6 = combination.calculateCombinations(query6, -10);
    ArrayList<HashSet<Integer>> result7 = combination.calculateCombinations(query7, 0);
    ArrayList<HashSet<Integer>> result8 = combination.calculateCombinations(query8, 50);

    System.out.println(
        "\n\n===========================================\n\nTest results \n\n===========================================\n");

    System.out.println("Array:" + Arrays.toString(query1) + "\nTarget: 15\nOutput: " + result1
        + "\nExpected: " + Arrays.deepToString(answer1) + "\nTest result: "
        + passOrFail(isCorrect(result1, answer1))
        + "\n===========================================");

    System.out.println("Array:" + Arrays.toString(query2) + "\nTarget: 6\nOutput: " + result2
        + "\nExpected: " + Arrays.deepToString(answer2) + "\nTest result: "
        + passOrFail(isCorrect(result2, answer2))
        + "\n===========================================");

    System.out.println("Array:" + Arrays.toString(query3) + "\nTarget: 10\nOutput: " + result3
        + "\nExpected: " + Arrays.deepToString(answer3) + "\nTest result: "
        + passOrFail(isCorrect(result3, answer3))
        + "\n===========================================");

    System.out.println("Array:" + Arrays.toString(query4) + "\nTarget: 120\nOutput: " + result4
        + "\nExpected: " + Arrays.deepToString(answer4) + "\nTest result: "
        + passOrFail(isCorrect(result4, answer4))
        + "\n===========================================");

    System.out.println("Array:" + Arrays.toString(query5) + "\nTarget: 13\nOutput: " + result5
        + "\nExpected: " + Arrays.deepToString(answer5) + "\nTest result: "
        + passOrFail(isCorrect(result5, answer5))
        + "\n===========================================");

    System.out.println("Array:" + Arrays.toString(query6) + "\nTarget: -10\nOutput: " + result6
        + "\nExpected: " + Arrays.deepToString(answer6) + "\nTest result: "
        + passOrFail(isCorrect(result6, answer6))
        + "\n===========================================");

    System.out.println("Array:" + Arrays.toString(query7) + "\nTarget: 0\nOutput: " + result7
        + "\nExpected: " + Arrays.deepToString(answer7) + "\nTest result: "
        + passOrFail(isCorrect(result7, answer7))
        + "\n===========================================");

    System.out.println("Array:" + Arrays.toString(query8) + "\nTarget: 50\nOutput: " + result8
        + "\nExpected: " + Arrays.deepToString(answer8) + "\nTest result: "
        + passOrFail(isCorrect(result8, answer8))
        + "\n===========================================");

  }

}
