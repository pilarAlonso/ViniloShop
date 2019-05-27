package com.demodisco.demodisco.Services.Impl;

import com.demodisco.demodisco.Entities.Size;
import com.demodisco.demodisco.Entities.Vinilo;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Models.VinilModelSnapshot;
import com.demodisco.demodisco.Repositories.ViniloRepository;
import com.demodisco.demodisco.Services.VinilSnapshotService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VinilModelSnapshotImpl implements VinilSnapshotService {

	private final ViniloRepository viniloRepository;

	public VinilModelSnapshotImpl(ViniloRepository viniloRepository) {

		this.viniloRepository = viniloRepository;
	}

	@Override
	public VinilModelSnapshot snapshot(VinilModelSnapshot vinilModelSnapshot) throws NotFound {

		List<Vinilo> lista = viniloRepository.findAll();

		if (lista.isEmpty()) throw new NotFound();

		vinilModelSnapshot.setVinilosNumber(viniloRepository.count());

		Map<Size, Long> viniloLongMap = lista.stream()
											 .collect(Collectors.groupingBy(Vinilo::getSize, Collectors.counting()));

		vinilModelSnapshot.setViniloLongMap(viniloLongMap);

		vinilModelSnapshot.setFiveMostSold(fiveMostSold());

		return vinilModelSnapshot;
	}

	public List<Vinilo> fiveMostSold() throws NotFound {

		Comparator<Vinilo> comparador1 = (p1, p2) -> Integer.compare(p1.getQuantityPurchase(), p2.getQuantityPurchase());

		List<Vinilo> viniloLista = viniloRepository.findAll().stream()
												   .sorted(comparador1)
												   .limit(5).collect(Collectors.toList());

		if (viniloLista.size() < 5 || viniloLista.isEmpty()) throw new NotFound();

		return viniloLista;
	}
}

