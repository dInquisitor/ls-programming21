package org.howard.edu.lsp.assignment7.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.howard.edu.lsp.assignment7.tollbooth.DisplayScreen;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestDisplayScreen {
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
    outContent.reset();
  }

  @Test
  @DisplayName("Test cases for display")
  void testDisplay() {
    DisplayScreen disp = new DisplayScreen();
    disp.display("THIS IS A TRUCK TEST");
    assertEquals(outContent.toString().trim(), "THIS IS A TRUCK TEST");
    outContent.reset();
    disp.display("THIS IS A TRUCK TEST\nWITH A NEWLINE");
    String output = outContent.toString().trim();
    assertTrue("THIS IS A TRUCK TEST\nWITH A NEWLINE".equals(output)
        || "THIS IS A TRUCK TEST\r\nWITH A NEWLINE".equals(output));
  }

}
