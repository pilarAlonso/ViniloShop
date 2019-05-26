package com.demodisco.demodisco.Controllers;

import com.demodisco.demodisco.Entities.Vinilo;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.ConflictException;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Models.VinilModelSnapshot;
import com.demodisco.demodisco.Services.VinilSnapshotService;
import com.demodisco.demodisco.Services.ViniloService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ViniloController {
	private final ViniloService viniloService;
	private final VinilSnapshotService vinilModelSnapshotService;

	public ViniloController(ViniloService viniloService, VinilSnapshotService vinilModelSnapshotService) {
		this.viniloService = viniloService;
		this.vinilModelSnapshotService = vinilModelSnapshotService;

	}

	@PutMapping("/vinilos/{id}")
	public Vinilo update(@Valid @RequestBody Vinilo vinilo, @PathVariable int id) throws NotFound, ConflictException {
		return viniloService.update(vinilo, id);

	}

	@DeleteMapping("/vinilos/{id}")

	public void delete(@PathVariable long id) throws NotFound {

		viniloService.delete(id);

	}

	@GetMapping("/vinilos")

	public List<Vinilo> findAll() throws NotFound {

		return viniloService.findAll();

	}

	@GetMapping("/vinilos/{id}")

	public Optional<Vinilo> findOne(@PathVariable long id) throws NotFound {

		return viniloService.findOne(id);

	}

	@PostMapping("/vinilos")
	public Vinilo save(@RequestBody Vinilo vinilo) throws BadRequest, ConflictException {
		return viniloService.save(vinilo);
	}

	@GetMapping("/vinilos/snapshot")
	public VinilModelSnapshot snapshot(VinilModelSnapshot vinilModelSnapshot) throws NotFound {
		return vinilModelSnapshotService.snapshot(vinilModelSnapshot);
	}

}
