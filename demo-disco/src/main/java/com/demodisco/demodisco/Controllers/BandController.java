package com.demodisco.demodisco.Controllers;

import com.demodisco.demodisco.Entities.Band;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Models.BandModelSnapshot;
import com.demodisco.demodisco.Services.BandModelSnapshotService;
import com.demodisco.demodisco.Services.BandService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BandController {
	private final BandService bandService;
	private final BandModelSnapshotService bandModelSnapshotService;

	public BandController(BandService bandService, BandModelSnapshotService bandModelSnapshotService) {
		this.bandService = bandService;
		this.bandModelSnapshotService = bandModelSnapshotService;
	}

	@PostMapping("/bands")
	public Band save(@Valid @RequestBody Band band) throws BadRequest {
		return bandService.save(band);
	}

	@GetMapping("/bands/snapshot")
	public BandModelSnapshot snapshot(BandModelSnapshot bandModelSnapshot) throws NotFound {
		return bandModelSnapshotService.snapshot(bandModelSnapshot);
	}

	@PutMapping("/bands/{id}")
	public Band update(@Valid @RequestBody Band band, @PathVariable int id) throws NotFound, BadRequest {
		return bandService.update(band, id);

	}

	@DeleteMapping("/bands/{id}")
	public void delete(@Valid @PathVariable long id) throws NotFound {
		bandService.delete(id);

	}

	@GetMapping("/bands")
	public List<Band> findAll() throws NotFound {

		return bandService.findAll();

	}

	@GetMapping("/bands/{id}")

	public Optional<Band> findOne(@PathVariable long id) throws NotFound {

		return bandService.findOne(id);

	}

}
