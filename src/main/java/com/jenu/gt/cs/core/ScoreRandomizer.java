package com.jenu.gt.cs.core;

import java.util.stream.IntStream;

public class ScoreRandomizer extends Randomizer {

	private static final int[] SCORES = IntStream.rangeClosed(0, 7).toArray();

	public ScoreRandomizer(int[] weights) {
		super(SCORES, weights);
	}

}
