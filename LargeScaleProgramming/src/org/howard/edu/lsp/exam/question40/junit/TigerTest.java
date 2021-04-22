package org.howard.edu.lsp.exam.question40.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.howard.edu.lsp.exam.question40.Animal;
import org.howard.edu.lsp.exam.question40.Tiger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Tiger class
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class TigerTest {
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
   * Tests the speak behavior of the tiger
   */
  @Test
  @DisplayName("test cases for speak")
  void testSpeak() {
    Animal tiger = new Tiger();
    tiger.speak();
    assertEquals(outContent.toString().trim(), "This Tiger speaks");
    outContent.reset();

    Tiger tiger2 = new Tiger();
    tiger2.speak();
    assertEquals(outContent.toString().trim(), "This Tiger speaks");
  }

  /**
   * Tests the move behavior of the tiger
   */
  @Test
  @DisplayName("test cases for move")
  void testMove() {
    Animal tiger = new Tiger();
    tiger.move();
    assertEquals(outContent.toString().trim(), "This Tiger moves forward");
    outContent.reset();

    Tiger tiger2 = new Tiger();
    tiger2.move();
    assertEquals(outContent.toString().trim(), "This Tiger moves forward");
  }
}
