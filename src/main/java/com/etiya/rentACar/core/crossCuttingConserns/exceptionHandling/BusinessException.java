package com.etiya.rentACar.core.crossCuttingConserns.exceptionHandling;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {
 public BusinessException(String message) {
	 
	 super(message);
 }
}
