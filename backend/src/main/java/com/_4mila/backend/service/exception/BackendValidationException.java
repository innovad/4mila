package com._4mila.backend.service.exception;

import java.util.ArrayList;
import java.util.List;

public class BackendValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String messageKey;
	private List<String> parameters = new ArrayList<>();

	public BackendValidationException(String messageKey) {
		super();
		this.messageKey = messageKey;
	}
	
	public String getMessageKey() {
		return messageKey;
	}
	
	public List<String> getParameters() {
		return parameters;
	}

}
