package org.howard.edu.lsp.assignment7.tollbooth;

/**
 * Toll booth interface
 * 
 * @author Ibukunoluwa Esan
 *
 */
public interface TollBooth {
  void calculateToll(Truck truck);

  void displayData();

  void reset();

  float getNumTrucks();

  float getTotalAmount();
}
