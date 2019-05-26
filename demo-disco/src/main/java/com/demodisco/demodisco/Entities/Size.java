package com.demodisco.demodisco.Entities;

public enum Size {

	BIG(30), MEDIUM(25), SMALL(17.5);

	Size(double size) {
		this.size = size;

	}

	private final double size;
}
