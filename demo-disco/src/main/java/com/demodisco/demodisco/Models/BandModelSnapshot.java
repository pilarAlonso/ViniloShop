package com.demodisco.demodisco.Models;

import com.demodisco.demodisco.Entities.Band;
import com.demodisco.demodisco.Entities.Vinilo;

import java.util.List;

public class BandModelSnapshot {
	private long numberGroup;
	private List<Band> fiveMostSoldGroup;

	public long getNumberGroup() {
		return numberGroup;
	}

	public void setNumberGroup(long numberGroup) {
		this.numberGroup = numberGroup;
	}

	public List<Band> getFiveMostSoldGroup() {

		return fiveMostSoldGroup;
	}

	public void setFiveMostSoldGroup(List<Band> fiveMostSoldGroup) {
		this.fiveMostSoldGroup = fiveMostSoldGroup;
	}

	public BandModelSnapshot() {
	}
}
