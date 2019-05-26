package com.demodisco.demodisco.Services.Impl;

import com.demodisco.demodisco.Entities.Band;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Repositories.BandRepository;
import com.demodisco.demodisco.Services.BandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandServiceImpl implements BandService {
	private final BandRepository bandRepository;

	public BandServiceImpl(BandRepository bandRepository) {
		this.bandRepository = bandRepository;
	}

	@Override
	public Band save(Band band)throws BadRequest {
		Optional<Band> bandOptional = bandRepository.findById(band.getId());
		if (bandOptional.isPresent())
			throw new BadRequest();
		Band band1 = new Band();
        band1.setId(band.getId());
		band1.setName(band.getName());
		band1.setMembers(band.getMembers());
		band1.setViniloList(band.getViniloList());

		return band1 = bandRepository.save(band);
	}

	@Override
	public List<Band> findAll() throws NotFound {
		if (bandRepository.findAll().isEmpty()) throw new NotFound();
		return bandRepository.findAll();
	}

	@Override
	public void delete(long id) throws NotFound {
		Optional<Band> optionalBand = bandRepository.findById(id);
		if (!optionalBand.isPresent()) throw new NotFound();
		bandRepository.deleteById(id);


	}

	@Override
	public Optional<Band> findOne(long id) throws NotFound {
		if (!bandRepository.findById(id).isPresent()) throw new NotFound();
		return bandRepository.findById(id);
	}

	@Override
	public Band update(Band band, long id) throws NotFound {
		if (!bandRepository.findById(id).isPresent()) throw new NotFound();

		return bandRepository.save(band);
	}


}
