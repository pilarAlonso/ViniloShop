package com.demodisco.demodisco.Models;

import com.demodisco.demodisco.Entities.Band;
import com.demodisco.demodisco.Entities.Vinilo;

import java.util.List;

public class BandModelSnapshot {
	private Long numberGroup;
	private List<Band> fiveMostSoldGroup;

	public Long getNumberGroup() {
		return numberGroup;
	}

	public void setNumberGroup(Long numberGroup) {
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
