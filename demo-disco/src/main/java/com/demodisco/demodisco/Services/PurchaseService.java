package com.demodisco.demodisco.Services;

import com.demodisco.demodisco.Entities.Purchase;
import com.demodisco.demodisco.Entities.Vinilo;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PurchaseService {
	List<Purchase> findAll() throws NotFound;
	void delete(long id) throws NotFound;
	Purchase save(Purchase purchase) throws BadRequest;
	Optional<Purchase> findOne(long id) throws NotFound;
	Purchase update(Purchase purchase, long id) throws NotFound;
}
