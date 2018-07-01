package com.jenu.gt.cs.bean;

import java.util.List;

public class Team {

	private final String name;
	private final List<Batsman> batsmen;

	private static final String SCORE_FORMAT = "%s - %d (%d balls)";

	@SuppressWarnings("unused")
	private Team() {
		this.name = null;
		this.batsmen = null;
	}

	public Team(String name, List<Batsman> batsmen) {
		this.name = name;
		this.batsmen = batsmen;
	}

	public String getName() {
		return name;
	}

	public List<Batsman> getBatsmen() {
		return batsmen;
	}

	public void displayScoreCard() {
		for (Batsman batsman : batsmen) {
			final String score = String.format(SCORE_FORMAT, batsman.getName(), batsman.getBalls(), batsman.getRuns());
			System.out.println(score);
		}
	}

}
