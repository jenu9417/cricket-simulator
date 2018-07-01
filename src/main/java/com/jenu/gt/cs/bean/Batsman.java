package com.jenu.gt.cs.bean;

import com.jenu.gt.cs.core.Randomizer;
import com.jenu.gt.cs.core.ScoreRandomizer;

public class Batsman {

	private final String name;
	private final int[] values;
	private final Randomizer randomizer;

	private int runs;
	private int balls;
	private boolean out;

	@SuppressWarnings("unused")
	private Batsman() {
		this.name = null;
		this.values = null;
		this.randomizer = null;
	}

	public Batsman(String name, int[] values) {
		this.name = name;
		this.values = values;
		this.randomizer = new ScoreRandomizer(this.values);
	}

	public String getName() {
		return name;
	}

	public int[] getValues() {
		return values;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public boolean isOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	}

	public Strike strike() {
		return new Strike(this.name, this.randomizer.randomValue());
	}

}
