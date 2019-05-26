package com.demodisco.demodisco.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@ManyToMany
	private Set<Vinilo> viniloSet;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Purchase> purchaseList;

	public Client() {
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

	public Set<Vinilo> getViniloSet() {
		return viniloSet;
	}

	public void setViniloSet(Set<Vinilo> viniloSet) {
		this.viniloSet = viniloSet;
	}

	public List<Purchase> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<Purchase> purchaseList) {
		this.purchaseList = purchaseList;
	}
}
