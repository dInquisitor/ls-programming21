package org.howard.edu.lsp.assignment7.tollbooth;


/**
 * TollBooth for Charles county
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class CharlesTollBooth implements TollBooth {
  BarCodeReader reader;
  DisplayScreen screen;
  float totalAmount;
  int numTrucks;

  public CharlesTollBooth() {
    reader = new BarCodeReader();
    totalAmount = 0;
    numTrucks = 0;
    screen = new DisplayScreen();
  }

  /**
   * Gets the total amount collected by the toll booth since last reset
   * 
   * @return total amount collected by toll booth since last reset
   */
  @Override
  public float getTotalAmount() {
    return totalAmount;
  }

  /**
   * Gets the total number of trucks that has passed by the toll booth since last reset
   * 
   * @return total number of trucks that passed toll booth since last reset
   */
  @Override
  public float getNumTrucks() {
    return numTrucks;
  }


  /**
   * Displays information about truck arriving at toll booth
   * 
   * @param numAxles number of axles of arriving truck
   * @param weight weight of arriving truck
   * @param tollDue toll amount due by arriving truck
   */
  private void displayTruckArrival(int numAxles, int weight, float tollDue) {
    screen.display("Truck Arrival - Axles: " + numAxles + " Total weight: " + weight
        + " Toll due: $" + String.format("%.2f", tollDue));
  }

  /**
   * Calculate the total amount due by arriving truck
   * 
   * @param truck arriving truck
   */
  @Override
  public void calculateToll(Truck truck) {
    int weight = reader.readWeight(truck);
    int numAxles = reader.readNumAxles(truck);
    float tollDue = 5 * numAxles + 10 * (weight / 500);
    numTrucks++;
    totalAmount += tollDue;
    displayTruckArrival(numAxles, weight, tollDue);
  }

  /**
   * Display all toll booth due and trucks totals
   *
   */
  @Override
  public void displayData() {
    screen.display("Totals since last collection - Receipts: $"
        + String.format("%.2f", this.totalAmount) + " Trucks: " + this.numTrucks);
  }

  /**
   * Resets all toll booth figures
   *
   */
  @Override
  public void reset() {
    screen.display("*** Collecting receipts  ***");
    displayData();
    totalAmount = 0;
    numTrucks = 0;
  }
}
