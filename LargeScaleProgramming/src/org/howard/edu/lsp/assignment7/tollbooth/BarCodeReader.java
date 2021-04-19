package org.howard.edu.lsp.assignment7.tollbooth;

/**
 * Class that reads details off a truck from its presented barcodes
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class BarCodeReader {

  /**
   * Read the number of axles off the truck barcode
   * 
   * @param truck Truck for which to get number of axles
   * @return number of axles input truck has
   */
  public int readNumAxles(Truck truck) {
    return truck.getNumAxles();
  }

  /**
   * Read the weight of the truck from the bill of laden
   * 
   * @param truck Truck for which to get weight
   * @return weight of input truck
   */
  public int readWeight(Truck truck) {
    return truck.getWeight();
  }
}
