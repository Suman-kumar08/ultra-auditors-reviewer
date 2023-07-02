package com.infosys.ultra.auditors.exception;

public class ClientRequestNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ClientRequestNotFoundException(String message) {
		super(message);
		
	}

}
