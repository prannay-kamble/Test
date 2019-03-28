package com.margonetwork.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TagNotFoundException extends RuntimeException {

	public TagNotFoundException(String exception) {

		super(exception);
	}

}
