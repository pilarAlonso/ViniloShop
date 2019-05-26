package com.demodisco.demodisco.Exceptions;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.Conflict;

public class ConflictException extends Exception {
	public ConflictException() {
		super("la entidad indicada ya existe");
	}
}
