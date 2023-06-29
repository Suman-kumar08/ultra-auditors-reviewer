package com.infosys.ultra.auditors.exception;

import java.util.Date;

public class ErrorMessage {
	private Date date;
	private String message;
	private String details;
	public ErrorMessage(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}
	@Override
	public String toString() {
		return "[ date: " + date + ",\n message:" + message + ",\n details: " + details+" ]" ;
	}

}
