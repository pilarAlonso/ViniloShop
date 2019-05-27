package com.demodisco.demodisco.Controllers;

import com.demodisco.demodisco.Entities.Client;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.ConflictException;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Services.ClientService;
import com.demodisco.demodisco.Services.ViniloService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
	private final ClientService clientService;


	public ClientController(ClientService clientService) {
		this.clientService = clientService;

	}

	@PutMapping("/clients/{id}")
	public Client update(@Valid @RequestBody Client client, @PathVariable int id) throws NotFound, BadRequest, ConflictException {
		return clientService.update(client, id);

	}

	@DeleteMapping("/clients/{id}")

	public void delete(@Valid @PathVariable long id) throws NotFound {

		clientService.delete(id);

	}

	@GetMapping("/clients")

	public List<Client> findAll() throws NotFound {

		return clientService.findAll();

	}

	@GetMapping("/clients/{id}")

	public Optional<Client> findOne(@PathVariable long id) throws NotFound {

		return clientService.findOne(id);

	}

	@PostMapping("/clients")
	public Client save(@Valid @RequestBody Client client) throws Exception {
		return clientService.save(client);
	}
	@PutMapping("/clients/{id2}/vinilo/{id}/{quantity}")
	public Client buy(@Valid @RequestBody Client client,@PathVariable long id2 ,@PathVariable long id,@PathVariable int  quantity) throws NotFound, BadRequest, ConflictException {

		return clientService.buy(id2, id,quantity);

	}


}
