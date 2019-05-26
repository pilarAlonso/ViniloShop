package com.demodisco.demodisco.Services.Impl;

import com.demodisco.demodisco.Entities.Purchase;
import com.demodisco.demodisco.Entities.Size;
import com.demodisco.demodisco.Entities.Vinilo;
import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Models.VinilModelSnapshot;
import com.demodisco.demodisco.Repositories.ViniloRepository;
import com.demodisco.demodisco.Services.VinilSnapshotService;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
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

		vinilModelSnapshot.setVinilosNumber(viniloRepository.count());
		List<Vinilo> lista = viniloRepository.findAll();
		if (lista.isEmpty()) throw new NotFound();

		Map<Size, Long> viniloLongMap = lista.stream()
											 .collect(Collectors.groupingBy(Vinilo::getSize, Collectors.counting()));

		vinilModelSnapshot.setViniloLongMap(viniloLongMap);

		lista.sort((x, y) -> Integer.compare(y.getClientSet().size(), x.getClientSet().size()));
		lista = lista.stream().limit(5).collect(Collectors.toList());
		if (lista.size() < 5 || lista.isEmpty()) throw new NotFound();

		vinilModelSnapshot.setFiveMostSold(lista);

		return vinilModelSnapshot;
	}
}

