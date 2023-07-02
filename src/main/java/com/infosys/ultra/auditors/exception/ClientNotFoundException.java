
package com.infosys.ultra.auditors.exception;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ClientNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public ClientNotFoundException(String message) {
		super(message);
		
	}
}
