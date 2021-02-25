package org.howard.edu.lsp.assignment4.implementation;

/**
 * This class implements the custom exception IntegerSetException
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class IntegerSetException extends Exception {

  private static final long serialVersionUID = 7771502616486391536L;

  /**
   * @param e thrown exception object
   */
  public IntegerSetException(String e) {
    super(e);
  }
}
