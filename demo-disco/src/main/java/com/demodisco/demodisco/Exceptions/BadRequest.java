package com.demodisco.demodisco.Exceptions;

import org.springframework.web.client.HttpClientErrorException;

public class BadRequest  extends Exception {
	public BadRequest() {
		super("Datos introducidos en formato incorrecto");
	}
}
