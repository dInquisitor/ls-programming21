package org.howard.edu.lsp.assignment7.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.howard.edu.lsp.assignment7.tollbooth.BarCodeReader;
import org.howard.edu.lsp.assignment7.tollbooth.FordTruck;
import org.howard.edu.lsp.assignment7.tollbooth.RamTruck;
import org.howard.edu.lsp.assignment7.tollbooth.Truck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBarCodeReader {

  BarCodeReader codeReader;

  @BeforeEach
  void newReader() {
    codeReader = new BarCodeReader();
  }

  @Test
  @DisplayName("Test cases for readNumAxles")
  void testReadNumAxles() {
    Truck fTruck = new FordTruck(4, 1000);
    assertEquals(codeReader.readNumAxles(fTruck), 4);
    Truck ramTruck = new RamTruck(2, 25000);
    assertEquals(codeReader.readNumAxles(ramTruck), 2);
  }

  @Test
  @DisplayName("Test cases for readWeight")
  void testReadWeight() {
    Truck fTruck = new FordTruck(4, 1000);
    assertEquals(codeReader.readWeight(fTruck), 1000);
    Truck ramTruck = new RamTruck(2, 25000);
    assertEquals(codeReader.readWeight(ramTruck), 25000);
  }

}
