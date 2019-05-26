package com.demodisco.demodisco.Services;

import com.demodisco.demodisco.Entities.Vinilo;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ViniloService {
	Vinilo save(Vinilo vinilo) throws BadRequest;
	List<Vinilo> findAll() throws NotFound;
	void delete(long id) throws NotFound;
	Optional<Vinilo> findOne(long id) throws NotFound;
	Vinilo update(Vinilo vinilo,long id) throws NotFound;


}
