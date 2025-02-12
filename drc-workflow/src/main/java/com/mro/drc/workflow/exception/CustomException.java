package com.mro.drc.workflow.exception;

public class CustomException extends RuntimeException 
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String message;
	  private String details;

	  public CustomException() {}

	  public CustomException(
	      String message, String details) {
	    this.message = message;
	    this.details = details;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	  
	  
}