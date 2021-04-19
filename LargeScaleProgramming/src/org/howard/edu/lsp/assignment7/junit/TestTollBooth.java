package org.howard.edu.lsp.assignment7.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.howard.edu.lsp.assignment7.tollbooth.CharlesTollBooth;
import org.howard.edu.lsp.assignment7.tollbooth.FordTruck;
import org.howard.edu.lsp.assignment7.tollbooth.RamTruck;
import org.howard.edu.lsp.assignment7.tollbooth.TollBooth;
import org.howard.edu.lsp.assignment7.tollbooth.Truck;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestTollBooth {

  TollBooth cTollBooth;

  private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final static PrintStream originalOut = System.out;

  @BeforeAll
  public static void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterAll
  public static void restoreStreams() {
    System.setOut(originalOut);
  }

  @BeforeEach
  void newBooth() {
    cTollBooth = new CharlesTollBooth();
    outContent.reset();
  }


  @Test
  @DisplayName("Test cases for calculateToll")
  void testCalculateToll() {
    Truck fTruck = new FordTruck(4, 5000);
    cTollBooth.calculateToll(fTruck);
    assertEquals(cTollBooth.getNumTrucks(), 1);
    assertEquals(cTollBooth.getTotalAmount(), 120.00);
    assertEquals("Truck Arrival - Axles: 4 Total weight: 5000 Toll due: $120.00",
        outContent.toString().trim());

    Truck ramTruck = new RamTruck(2, 15000);
    cTollBooth.calculateToll(ramTruck);
    assertEquals(cTollBooth.getNumTrucks(), 2);
    assertEquals(cTollBooth.getTotalAmount(), 430.00);
  }

  @Test
  @DisplayName("Test cases for displayData")
  void testDisplayData() {
    Truck fTruck = new FordTruck(4, 5000);
    cTollBooth.calculateToll(fTruck);
    outContent.reset();
    cTollBooth.displayData();
    assertEquals("Totals since last collection - Receipts: $120.00 Trucks: 1",
        outContent.toString().trim());
    Truck ramTruck = new RamTruck(2, 15000);
    cTollBooth.calculateToll(ramTruck);
    outContent.reset();
    cTollBooth.displayData();
    assertEquals("Totals since last collection - Receipts: $430.00 Trucks: 2",
        outContent.toString().trim());
  }

  @Test
  @DisplayName("Test cases for reset")
  void testReset() {
    Truck fTruck = new FordTruck(4, 5000);
    cTollBooth.calculateToll(fTruck);
    Truck ramTruck = new RamTruck(2, 15000);
    cTollBooth.calculateToll(ramTruck);
    outContent.reset();
    cTollBooth.reset();
    String output = outContent.toString().trim();
    assertTrue(("*** Collecting receipts  ***\r\n"
        + "Totals since last collection - Receipts: $430.00 Trucks: 2").equals(output)
        || ("*** Collecting receipts  ***\n"
            + "Totals since last collection - Receipts: $430.00 Trucks: 2").equals(output));
    assertEquals(cTollBooth.getTotalAmount(), 0);
    assertEquals(cTollBooth.getNumTrucks(), 0);
  }
}
