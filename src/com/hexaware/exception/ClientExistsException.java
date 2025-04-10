package com.hexaware.exception;

import com.hexaware.util.HexaConstants;

public class ClientExistsException extends Exception {

	public ClientExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ClientExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ClientExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ClientExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return HexaConstants.CLIENT_EXISTS_EXCEPTION;
	}
	
	

	
	
}
