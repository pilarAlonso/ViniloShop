package com.demodisco.demodisco.Controllers;

import com.demodisco.demodisco.Entities.Purchase;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.ConflictException;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Services.PurchaseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PurchaseControllers {
	private final PurchaseService purchaseService;

	public PurchaseControllers(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	@PutMapping("/purchases/{id}")
	public Purchase update(@Valid @RequestBody Purchase purchase, @PathVariable int id) throws NotFound, ConflictException {
		return purchaseService.update(purchase, id);

	}

	@DeleteMapping("/purchases/{id}")

	public void delete(@Valid @PathVariable long id) throws NotFound {

		purchaseService.delete(id);

	}

	@GetMapping("/purchases")

	public List<Purchase> findAll() throws NotFound {

		return purchaseService.findAll();

	}

	@GetMapping("/purchases/{id}")

	public Optional<Purchase> findOne(@PathVariable long id) throws NotFound {

		return purchaseService.findOne(id);

	}

	@PostMapping("/purchases")
	public Purchase save(@Valid @RequestBody Purchase purchase) throws BadRequest, ConflictException {
		return purchaseService.save(purchase);
	}

}
