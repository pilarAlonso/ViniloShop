package com.demodisco.demodisco.Services;

import com.demodisco.demodisco.Entities.Band;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.ConflictException;
import com.demodisco.demodisco.Exceptions.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BandService {
	Band save(Band band) throws BadRequest, ConflictException;
	List<Band> findAll() throws NotFound;
	void delete(long id) throws NotFound;
	Optional<Band> findOne(long id) throws NotFound;
	Band update(Band band, long id) throws NotFound, ConflictException;

}
