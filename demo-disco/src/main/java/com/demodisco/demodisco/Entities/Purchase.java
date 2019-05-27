package com.demodisco.demodisco.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseOrder;
	@NotNull
	@DateTimeFormat
	private LocalDateTime date;
	@NotNull
	@Min(1)
	private int quantity;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Client client;
	@ManyToOne
	private Vinilo vinilo;

	public Vinilo getVinilo() {
		return vinilo;
	}

	public void setVinilo(Vinilo vinilo) {
		this.vinilo = vinilo;
	}

	public Purchase() {
	}

	public Long getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(Long purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
