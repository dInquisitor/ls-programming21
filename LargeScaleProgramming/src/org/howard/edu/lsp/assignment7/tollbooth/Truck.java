package org.howard.edu.lsp.assignment7.tollbooth;

/**
 * Truck interface
 * 
 * @author Ibukunoluwa Esan
 *
 */
public abstract class Truck {

  int numAxles;
  int weight;


  Truck(int numAxles, int weight) {
    this.numAxles = numAxles;
    this.weight = weight;
  }

  /**
   * Gets the number of axles the truck has
   * 
   * @return number of axles the truck has
   */
  public int getNumAxles() {
    return this.numAxles;
  }

  /**
   * Gets the weight of the truck
   * 
   * @return the weight of the truck
   */
  public int getWeight() {
    return this.weight;
  }

}
