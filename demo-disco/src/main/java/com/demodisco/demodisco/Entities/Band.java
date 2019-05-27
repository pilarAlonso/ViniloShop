package com.demodisco.demodisco.Entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Band {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String name;
	@NotNull
	@Min(1)
	private int members;
	@OneToMany(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.REMOVE)
	private List<Vinilo> viniloList;



	public void addVinil(Vinilo vinilo) {
		viniloList.add(vinilo);

	}

	public Band() {
	}

	public List<Vinilo> mostSold() {

		Comparator<Vinilo> comparador1 = (p1, p2) -> Integer.compare(p1.getQuantityPurchase(), p2.getQuantityPurchase());
		List<Vinilo> viniloLista = viniloList.stream()
										.sorted(comparador1)
										.collect(Collectors.toList());
		return viniloLista;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public List<Vinilo> getViniloList() {
		return viniloList;
	}

	public void setViniloList(List<Vinilo> viniloList) {
		this.viniloList = viniloList;
	}
}
