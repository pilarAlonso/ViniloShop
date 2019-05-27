package com.demodisco.demodisco.Services.Impl;

import com.demodisco.demodisco.Entities.Band;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Models.BandModelSnapshot;
import com.demodisco.demodisco.Repositories.BandRepository;
import com.demodisco.demodisco.Services.BandModelSnapshotService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BandModelSnapshotImpl implements BandModelSnapshotService {

	private final BandRepository bandRepository;

	public BandModelSnapshotImpl(BandRepository bandRepository) {
		this.bandRepository = bandRepository;
	}

	@Override
	public BandModelSnapshot snapshot(BandModelSnapshot bandModelSnapshot) throws NotFound {

		List<Band> lista = bandRepository.findAll();

		if (lista.isEmpty()) throw new NotFound();

		bandModelSnapshot.setNumberGroup(bandRepository.count());

		bandModelSnapshot.setFiveMostSoldGroup(fiveMostSold());

		return bandModelSnapshot;

	}

	public List<Band> fiveMostSold() throws NotFound {

		Comparator<Band> comparador1 = (x, y) -> Integer.compare(y.mostSold().size(), x.mostSold().size());

		List<Band> list = bandRepository.findAll().stream()
										.sorted(comparador1)
										.collect(Collectors.toList());

		if (list.size() < 5) throw new NotFound();

		return list;

	}
}
