package com.h.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
	
	private int code;
	private String msg;
	
	@Override
	public String toString() {
		return "ErrorResponse [code=" + code + ", msg=" + msg + "]";
	}
	
	

}
