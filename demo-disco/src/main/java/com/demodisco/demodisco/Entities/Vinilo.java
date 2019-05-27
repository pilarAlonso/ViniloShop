package com.demodisco.demodisco.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
	@OneToMany(mappedBy = "vinilo")
	private List<Purchase>purchaseList=new ArrayList<>();
	public int getQuantityPurchase(){
		 return purchaseList.stream().mapToInt(Purchase::getQuantity).sum();
	}

	public List<Purchase> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<Purchase> purchaseList) {
		this.purchaseList = purchaseList;
	}

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
