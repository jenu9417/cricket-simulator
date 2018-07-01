package com.jenu.gt.cs.core;

import java.util.Arrays;
import java.util.Random;

public class Randomizer {

	private final int[] values;

	private final int[] weights;

	private final int weightSum;

	private final Random random;

	@SuppressWarnings("unused")
	private Randomizer() {
		this.values = null;
		this.weights = null;
		this.weightSum = 0;
		this.random = null;
	}

	protected Randomizer(int[] values, int[] weights) {
		if (values == null || weights == null || values.length != weights.length || values.length < 1) {
			throw new IllegalArgumentException();
		}

		this.values = values;
		this.weights = weights;
		this.weightSum = Arrays.stream(this.weights).sum();
		this.random = new Random();
	}

	public int[] getValues() {
		return values;
	}

	public int[] getWeights() {
		return weights;
	}

	public int randomValue() {
		int randomToken = random.nextInt(weightSum) + 1;
		int i = -1;
		while (randomToken > 0) {
			randomToken -= weights[++i];
		}

		return values[i];
	}

}
