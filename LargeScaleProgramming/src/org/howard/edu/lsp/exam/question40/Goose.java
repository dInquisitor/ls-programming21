package org.howard.edu.lsp.exam.question40;

/**
 * The Goose class
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class Goose extends Animal implements Flying {
  public Goose() {
    this.animalName = "Goose";
  }

  /**
   * Implements the flying behavior for goose
   */
  @Override
  public void fly() {
    System.out.println("This goose can fly by flapping its wings");
  }

}
