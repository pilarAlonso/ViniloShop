package com.demodisco.demodisco.Services;

import com.demodisco.demodisco.Entities.Client;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
	Client save(Client client) throws BadRequest;
	List<Client> findAll() throws NotFound;
	void delete(long id) throws NotFound;
	Optional<Client> findOne(long id) throws NotFound;
	Client update(Client client, long id) throws NotFound, BadRequest;
}
