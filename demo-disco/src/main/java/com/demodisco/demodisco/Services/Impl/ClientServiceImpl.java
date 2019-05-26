package com.demodisco.demodisco.Services.Impl;

import com.demodisco.demodisco.Entities.Client;
import com.demodisco.demodisco.Entities.Vinilo;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Repositories.ClientRepository;
import com.demodisco.demodisco.Services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
	private  final ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client save(Client client) throws BadRequest {
		Optional<Client> clientOptional = clientRepository.findById(client.getId());
		if (clientOptional.isPresent())
			throw new BadRequest();
		Client client1 = new Client();

		client1.setId(client.getId());
		client1.setName(client.getName());
		client1.setPurchaseList(client.getPurchaseList());
		client1.setViniloSet(client.getViniloSet());


		return client1 =clientRepository.save(client);
	}

	@Override
	public List<Client> findAll() throws NotFound {
		if (clientRepository.findAll().isEmpty()) throw new NotFound();
		return clientRepository.findAll();
	}

	@Override
	public void delete(long id) throws NotFound {
		Optional<Client> ViniloptionalClient = clientRepository.findById(id);
		if (!ViniloptionalClient.isPresent()) throw new NotFound();
		clientRepository.deleteById(id);

	}

	@Override
	public Optional<Client> findOne(long id) throws NotFound {
		if (!clientRepository.findById(id).isPresent()) throw new NotFound();
		return clientRepository.findById(id);
	}

	@Override
	public Client update(Client client, long id) throws NotFound, BadRequest {
		if (!clientRepository.findById(id).isPresent()) throw new NotFound();

		return clientRepository.save(client);
	}

}

