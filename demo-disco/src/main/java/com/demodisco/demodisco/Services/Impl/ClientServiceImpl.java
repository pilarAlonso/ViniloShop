package com.demodisco.demodisco.Services.Impl;

import com.demodisco.demodisco.Entities.Client;
import com.demodisco.demodisco.Entities.Vinilo;
import com.demodisco.demodisco.Exceptions.ConflictException;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Repositories.ClientRepository;
import com.demodisco.demodisco.Repositories.PurchaseRepository;
import com.demodisco.demodisco.Repositories.ViniloRepository;
import com.demodisco.demodisco.Services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
	private  final ClientRepository clientRepository;
	private final ViniloRepository viniloRepository;
	private final PurchaseRepository purchaseRepository;

	public ClientServiceImpl(ClientRepository clientRepository, ViniloRepository viniloRepository, PurchaseRepository purchaseRepository) {
		this.clientRepository = clientRepository;
		this.viniloRepository = viniloRepository;
		this.purchaseRepository = purchaseRepository;
	}

	@Override
	public Client save(Client client) throws Exception {
		Optional<Client> clientOptional = clientRepository.findById(client.getId());
		if (clientOptional.isPresent())
			throw new ConflictException();
		Client client1 = new Client();

		client1.setId(client.getId());
		client1.setName(client.getName());
		client1.setPurchaseList(client.getPurchaseList());
		if(!client1.getPurchaseList().isEmpty())throw new Exception("la lista de compras de un cliente no puede contener datos en esta operación");
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
		clientRepository.findById(id).orElseThrow(()->new NotFound());
		clientRepository.deleteById(id);

	}

	@Override
	public Optional<Client> findOne(long id) throws NotFound {
		clientRepository.findById(id).orElseThrow(()->new NotFound());
		return clientRepository.findById(id);
	}

	@Override
	public Client update(Client client, long id) throws  NotFound {
	clientRepository.findById(id).orElseThrow(()->new NotFound());


	return clientRepository.save(client);
	}

	@Override
	public Client buy(long id2, long id,int quantity) throws NotFound {
		viniloRepository.findById(id).orElseThrow(()->new NotFound());
		clientRepository.findById(id2).orElseThrow(()->new NotFound());
		Vinilo vinilo=viniloRepository.findById(id).get();
		Client client=clientRepository.findById(id2).get();
		purchaseRepository.save(client.buyVinil(client, vinilo, quantity));
		return clientRepository.save(client);

	}

}

