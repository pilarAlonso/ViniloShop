package com.demodisco.demodisco.Services.Impl;

import com.demodisco.demodisco.Entities.Size;
import com.demodisco.demodisco.Entities.Vinilo;
import com.demodisco.demodisco.Exceptions.BadRequest;
import com.demodisco.demodisco.Exceptions.ConflictException;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Repositories.ViniloRepository;
import com.demodisco.demodisco.Services.ViniloService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ViniloServiceImpl implements ViniloService {
	private final ViniloRepository viniloRepository;

	public ViniloServiceImpl(ViniloRepository viniloRepository) {
		this.viniloRepository = viniloRepository;
	}

	@Override
	public Vinilo save(Vinilo vinilo) throws ConflictException {
		Optional<Vinilo> viniloOptional = viniloRepository.findById(vinilo.getId());
		if (viniloOptional.isPresent())
			throw new ConflictException();
		Vinilo vinilo1 = new Vinilo();

		vinilo1.setName(vinilo.getName());

		vinilo1.setSize(vinilo.getSize());


		vinilo1.setBand(vinilo.getBand());

		return vinilo1 = viniloRepository.save(vinilo);

	}

	@Override
	public Optional<Vinilo> findOne(long id) throws NotFound {
		if (!viniloRepository.findById(id).isPresent()) throw new NotFound();
		return viniloRepository.findById(id);
	}

	@Override
	public Vinilo update(Vinilo vinilo, long id) throws ConflictException {
		if (!viniloRepository.findById(id).isPresent()) throw new ConflictException();

		return viniloRepository.save(vinilo);
	}

	@Override
	public List<Vinilo> findAll() throws NotFound {
		if (viniloRepository.findAll().isEmpty()) throw new NotFound();
		return viniloRepository.findAll();


	}

	@Override
	public void delete(long id) throws NotFound {
		Optional<Vinilo> ViniloOptional = viniloRepository.findById(id);
		if (!ViniloOptional.isPresent()) throw new NotFound();
         viniloRepository.deleteById(id);
	}

}
