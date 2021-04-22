package org.howard.edu.lsp.exam.question40.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.howard.edu.lsp.exam.question40.Animal;
import org.howard.edu.lsp.exam.question40.Flying;
import org.howard.edu.lsp.exam.question40.Goose;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Goose class
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class GooseTest {
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
   * Tests the fly behavior of the goose
   */
  @Test
  @DisplayName("test cases for fly")
  void testFly() {
    Animal goose = new Goose();
    ((Flying) goose).fly();
    assertEquals(outContent.toString().trim(), "This goose can fly by flapping its wings");
    outContent.reset();
    Flying goose2 = new Goose();
    goose2.fly();
    assertEquals(outContent.toString().trim(), "This goose can fly by flapping its wings");
    outContent.reset();
    Goose goose3 = new Goose();
    goose3.fly();
    assertEquals(outContent.toString().trim(), "This goose can fly by flapping its wings");
  }

  /**
   * Tests the speak behavior of the goose
   */
  @Test
  @DisplayName("test cases for speak")
  void testSpeak() {
    Animal goose = new Goose();
    goose.speak();
    assertEquals(outContent.toString().trim(), "This Goose speaks");
    outContent.reset();
    Flying goose2 = new Goose();
    ((Animal) goose2).speak();
    assertEquals(outContent.toString().trim(), "This Goose speaks");
    outContent.reset();
    Goose goose3 = new Goose();
    goose3.speak();
    assertEquals(outContent.toString().trim(), "This Goose speaks");
  }

  /**
   * Tests the move behavior of the goose
   */
  @Test
  @DisplayName("test cases for move")
  void testMove() {
    Animal goose = new Goose();
    goose.move();
    assertEquals(outContent.toString().trim(), "This Goose moves forward");
    outContent.reset();
    Flying goose2 = new Goose();
    ((Animal) goose2).move();
    assertEquals(outContent.toString().trim(), "This Goose moves forward");
    outContent.reset();
    Goose goose3 = new Goose();
    goose3.move();
    assertEquals(outContent.toString().trim(), "This Goose moves forward");
  }
}
