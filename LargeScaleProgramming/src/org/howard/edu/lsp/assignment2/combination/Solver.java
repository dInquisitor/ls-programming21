package org.howard.edu.lsp.assignment2.combination;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Ibukunoluwa Esan
 *
 */
public class Solver {

  private ArrayList<HashSet<Integer>> result;

  /**
   * This constructor initializes a list where the results of the computation will be stored
   */
  public Solver() {
    result = new ArrayList<HashSet<Integer>>();
  }

  /**
   * This method implements the recursive part of the computation. It adds valid sets to the results
   * list
   * 
   * @param index - current position in the list in this recursive frame
   * @param resultSet - running set of the indices of "picked" numbers that add up to currentSum
   * @param originalInput - original input array
   * @param currentSum - running total of "picked" numbers
   * @param targetSum - original targeted sum
   */
  private void calculateHelper(int index, HashSet<Integer> resultSet, int[] originalInput,
      int currentSum, int targetSum) {
    // Recursive base case, there are no more elements to be picked
    if (index < 0) {
      if (currentSum == targetSum) {
        result.add(resultSet);
      }
      return;
    }
    HashSet<Integer> newResultSet = new HashSet<Integer>(resultSet);
    newResultSet.add(index);
    // Simulate picking element at current index
    calculateHelper(index - 1, newResultSet, originalInput, currentSum + originalInput[index],
        targetSum);
    // Simulate not picking element at current index
    calculateHelper(index - 1, resultSet, originalInput, currentSum, targetSum);
  }


  /**
   * This method initialized the recursive implementation of the computation
   * 
   * @param input - input array
   * @param targetSum - target sum
   * @return a list of the set of indices of the numbers that add up to targetSum
   */
  public ArrayList<HashSet<Integer>> calculateCombinations(int[] input, int targetSum) {
    calculateHelper(input.length - 1, new HashSet<Integer>(), input, 0, targetSum);
    // Copy the global results so we can clear it in preparation for future computations
    ArrayList<HashSet<Integer>> output = new ArrayList<HashSet<Integer>>(result);
    result.clear();
    if (output.size() == 1 && output.get(0).size() == 0) {
      output.clear();
    }
    return output;
  }
}
