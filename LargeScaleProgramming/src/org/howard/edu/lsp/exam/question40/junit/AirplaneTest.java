package org.howard.edu.lsp.exam.question40.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.howard.edu.lsp.exam.question40.Airplane;
import org.howard.edu.lsp.exam.question40.Flying;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class tests the AirPlane class
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class AirplaneTest {

  private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final static PrintStream originalOut = System.out;

  /**
   * Set up output streams for testing system out calls
   */
  @BeforeAll
  public static void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  /**
   * Reset system out streams to standard out
   */
  @AfterAll
  public static void restoreStreams() {
    System.setOut(originalOut);
  }

  /**
   * Resets output buffer used to test system out calls
   */
  @BeforeEach
  void resetOutput() {
    outContent.reset();
  }

  /**
   * Tests the fly behavior of the airplane
   */
  @Test
  @DisplayName("test cases for fly")
  void testFly() {
    Airplane plane = new Airplane();
    plane.fly();
    assertEquals(outContent.toString().trim(), "This object can fly by moving fast");
    outContent.reset();
    Flying plane2 = new Airplane();
    plane2.fly();
    assertEquals(outContent.toString().trim(), "This object can fly by moving fast");
  }
}
