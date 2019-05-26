package com.demodisco.demodisco.Entities;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Vinilo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String name;
	@NotNull
	@DateTimeFormat
	private String data;
	@NotNull
	private Size size;
	@ManyToOne
	private Band band;
	@ManyToMany(mappedBy = "viniloSet")
	private List<Client> clientSet = new ArrayList<>();

	public Vinilo() {
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Band getBand() {
		return band;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	public List<Client> getClientSet() {
		return clientSet;
	}

	public void setClientSet(List<Client> clientSet) {
		this.clientSet = clientSet;
	}
}
