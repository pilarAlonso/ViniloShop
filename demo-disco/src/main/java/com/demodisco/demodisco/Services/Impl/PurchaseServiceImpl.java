package com.demodisco.demodisco.Services.Impl;

import com.demodisco.demodisco.Entities.Purchase;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Repositories.PurchaseRepository;
import com.demodisco.demodisco.Services.PurchaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	private final PurchaseRepository purchaseRepository;

	public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}

	@Override
	public List<Purchase> findAll() throws NotFound {
		if (purchaseRepository.findAll().isEmpty()) throw new NotFound();
		return purchaseRepository.findAll();
	}

	@Override
	public void delete(long id) throws NotFound {
		Optional<Purchase> purchaseOptional = purchaseRepository.findById(id);
		if (!purchaseOptional.isPresent()) throw new NotFound();
		purchaseRepository.deleteById(id);

	}

	@Override
	public Purchase save(Purchase purchase) throws BadRequest {
		Optional<Purchase> purchaseOptional = purchaseRepository.findById(purchase.getPurchaseOrder());
		if (purchaseOptional.isPresent())
			throw new BadRequest();
		Purchase purchase1 = new Purchase();

		purchase1.setClient(purchase.getClient());
		purchase1.setDate(purchase.getDate());
		purchase1.setPurchaseOrder(purchase.getPurchaseOrder());
		purchase1.setQuantity(purchase.getQuantity());

		return purchase1 = purchaseRepository.save(purchase);
	}

	@Override
	public Optional<Purchase> findOne(long id) throws NotFound {
		if (!purchaseRepository.findById(id).isPresent()) throw new NotFound();
		return purchaseRepository.findById(id);
	}

	@Override
	public Purchase update(Purchase purchase, long id) throws NotFound {
		if (!purchaseRepository.findById(id).isPresent()) throw new NotFound();

		return purchaseRepository.save(purchase);
	}

}
