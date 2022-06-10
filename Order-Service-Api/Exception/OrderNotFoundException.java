package com.prashanth.app.Exception;

public class OrderNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderNotFoundException(String masg) {
		super(masg);
	}
	
}
