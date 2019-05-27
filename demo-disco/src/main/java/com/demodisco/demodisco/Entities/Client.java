package com.demodisco.demodisco.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

	public void addVinil(Vinilo vinilo) {
		viniloSet.add(vinilo);
	}

	public void buyVinil(Client client, Vinilo vinilo, int quantity) {
		addVinil(vinilo);
		Purchase buyVinil = new Purchase();
		buyVinil.setQuantity(quantity);
		buyVinil.setDate(LocalDateTime.now());
		buyVinil.setClient(client);
		purchaseList.add(buyVinil);

	}

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
