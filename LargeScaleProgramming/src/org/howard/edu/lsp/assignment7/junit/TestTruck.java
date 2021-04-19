package org.howard.edu.lsp.assignment7.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.howard.edu.lsp.assignment7.tollbooth.FordTruck;
import org.howard.edu.lsp.assignment7.tollbooth.RamTruck;
import org.howard.edu.lsp.assignment7.tollbooth.Truck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestTruck {

  @Test
  @DisplayName("Test cases for getNumAxles")
  void testGetNumAxles() {
    Truck fordTruck = new FordTruck(2, 5000);
    assertEquals(fordTruck.getNumAxles(), 2);
    Truck ramTruck = new RamTruck(4, 15000);
    assertEquals(ramTruck.getNumAxles(), 4);
  }

  @Test
  @DisplayName("Test cases for getWeight")
  void testGetWeight() {
    Truck fordTruck = new FordTruck(2, 5000);
    assertEquals(fordTruck.getWeight(), 5000);
    Truck ramTruck = new RamTruck(4, 15000);
    assertEquals(ramTruck.getWeight(), 15000);
  }

}
