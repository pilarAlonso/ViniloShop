package com.demodisco.demodisco.Exceptions;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.Conflict;

public class ConflictException extends Exception {
	public ConflictException(String message) {
		super("la entidad indicada ya existe");
	}
}
