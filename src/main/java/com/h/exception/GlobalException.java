package com.h.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=AlreadyExistException.class)
	@ResponseBody
	public ErrorResponse AlreadyExistException(AlreadyExistException be) {
		ErrorResponse er = new ErrorResponse();
		er.setCode(HttpStatus.CONFLICT.value());
		er.setMsg(be.getMessage());
		return er;
		
	}
	
	@ExceptionHandler(value=NotFound.class)
	@ResponseBody
	public ErrorResponse handleBookNotFound(NotFound be) {
		ErrorResponse er = new ErrorResponse();
		er.setCode(HttpStatus.NOT_FOUND.value());
		er.setMsg(be.getMessage());
		return er;
		
	}
	
	
	

}
