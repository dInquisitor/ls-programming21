package org.howard.edu.lsp.assignment7.tollbooth;

/**
 * Represents a Ford truck
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class FordTruck extends Truck {

  private static String make = "Ford";

  public FordTruck(int numAxles, int weight) {
    super(numAxles, weight);
  }

  /**
   * Gets truck make
   * 
   * @return truck make
   */
  public static String getMake() {
    return make;
  }
}
