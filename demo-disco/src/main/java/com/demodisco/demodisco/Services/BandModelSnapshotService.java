package com.demodisco.demodisco.Services;

import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Models.BandModelSnapshot;
import com.demodisco.demodisco.Models.VinilModelSnapshot;
import org.springframework.stereotype.Service;

@Service
public interface BandModelSnapshotService {
	BandModelSnapshot snapshot(BandModelSnapshot bandModelSnapshot) throws NotFound;
}
