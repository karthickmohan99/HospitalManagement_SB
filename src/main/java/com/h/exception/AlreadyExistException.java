package com.h.exception;

public class AlreadyExistException extends RuntimeException {
	
	String msg;

	public AlreadyExistException(String msg) {
		super(msg);
		this.msg = msg;
	}
	

}
