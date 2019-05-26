package com.demodisco.demodisco.Exceptions;

import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

public class NotFound extends NotFoundException {
	public NotFound() {
		super("Los datos requeridos no han sido encontrados");
	}
}
