package com.challenge.exception;

public class UserNotFoundException extends RuntimeException {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String name) {
	    super("Acceleration name not found"+ name);
	  }
	}