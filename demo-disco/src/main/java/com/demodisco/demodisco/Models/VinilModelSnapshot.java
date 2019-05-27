package com.demodisco.demodisco.Models;

import com.demodisco.demodisco.Entities.Size;
import com.demodisco.demodisco.Entities.Vinilo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VinilModelSnapshot {

	private List<Vinilo> fiveMostSold = new ArrayList<>();
	private long vinilosNumber;
	Map<Size, Long> viniloLongMap = new HashMap<>();

	public Map<Size, Long> getViniloLongMap() {
		return viniloLongMap;
	}

	public void setViniloLongMap(Map<Size, Long> viniloLongMap) {
		this.viniloLongMap = viniloLongMap;
	}

	public List<Vinilo> getFiveMostSold() {
		return fiveMostSold;
	}

	public void setFiveMostSold(List<Vinilo> fiveMostSold) {
		this.fiveMostSold = fiveMostSold;
	}

	public long getVinilosNumber() {
		return vinilosNumber;
	}

	public void setVinilosNumber(long vinilosNumber) {
		this.vinilosNumber = vinilosNumber;
	}

	public VinilModelSnapshot() {
	}
}
