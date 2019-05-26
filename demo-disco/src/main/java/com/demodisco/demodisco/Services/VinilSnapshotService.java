package com.demodisco.demodisco.Services;

import com.demodisco.demodisco.Exceptions.NotFound;
import com.demodisco.demodisco.Models.VinilModelSnapshot;
import org.springframework.stereotype.Service;

@Service
public interface VinilSnapshotService {

	VinilModelSnapshot snapshot(VinilModelSnapshot vinilModelSnapshot) throws NotFound;

}
