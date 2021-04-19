package org.howard.edu.lsp.assignment7.tollbooth;

/**
 * Represents a RAM truck
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class RamTruck extends Truck {

  private static String make = "RAM";

  public RamTruck(int numAxles, int weight) {
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
