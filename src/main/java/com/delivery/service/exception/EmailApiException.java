package com.delivery.service.exception;

public class EmailApiException extends RuntimeException {

	private static final long serialVersionUID = -7959728823477726713L;

	public EmailApiException(String message) {
		super(message);
	}
}
