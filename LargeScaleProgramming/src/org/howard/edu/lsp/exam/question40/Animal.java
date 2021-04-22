package org.howard.edu.lsp.exam.question40;

/**
 * General animal class
 * 
 * @author Ibukunoluwa Esan
 *
 */
public abstract class Animal {

  String animalName;

  Animal() {
    animalName = "animal";
  }

  /**
   * Implements the speaking behavior for animals in general
   */
  public void speak() {
    System.out.println("This " + animalName + " speaks");
  }

  /**
   * Implements the moving behavior for animals in general
   */
  public void move() {
    System.out.println("This " + animalName + " moves forward");
  }

}
