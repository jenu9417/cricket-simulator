package com.jenu.gt.cs.bean;

public class Strike {

	private final int runs;
	private final String batsman;

	@SuppressWarnings("unused")
	private Strike() {
		this.runs = 0;
		this.batsman = null;
	}

	public Strike(String batsman, int runs) {
		this.batsman = batsman;
		this.runs = runs;
	}

	public int getRuns() {
		return runs;
	}

	public String getBatsman() {
		return batsman;
	}

}
