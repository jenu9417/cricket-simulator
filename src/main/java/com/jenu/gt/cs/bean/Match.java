package com.jenu.gt.cs.bean;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Match {

	private final Map<Integer, Strike> scoreCard = new LinkedHashMap<>(40);
	private final int target;
	private final int maxBalls;
	private final int maxWickets;

	private int totalRuns = 0;
	private int wickets = 0;
	private int balls;

	private Status currentStatus;

	private Team team;
	private final Iterator<Batsman> batsmenIterator;

	private Batsman batsman1;
	private Batsman batsman2;

	private Batsman striker;

	private String resultFormat = "%s %s by %s";
	private String winFormat = "%d wicket and %d balls remaining";
	private String lossFormat = "%d runs";
	private String overDescFormat = "%d overs left. %d runs to win";

	public Match(Team team, int target, int maxBalls, int maxWickets) {
		this.team = team;
		this.target = target;
		this.maxBalls = maxBalls;
		this.maxWickets = maxWickets - 1;
		this.batsmenIterator = this.team.getBatsmen().iterator();
	}

	private void initializeMatch() {
		batsman1 = nextBatsman();
		batsman2 = nextBatsman();

		striker = batsman1;
		currentStatus = Status.IN_PROGRESS;
	}

	public void simulateMatch() {
		initializeMatch();
		try {
			while (currentStatus == Status.IN_PROGRESS) {
				final Strike strike = striker.strike();
				final int runs = strike.getRuns();
				scoreCard.put(++balls, strike);

				if (runs == 7) {
					// System.out.println(
					// "Ball : " + balls + " " + strike.getBatsman() + " scored
					// " + strike.getRuns() + " runs.");
					if (++wickets == maxWickets) {
						currentStatus = Status.LOSS;
						break;
					}
					rotateBatsman();
				} else {
					if (runs % 2 != 0) {
						rotateStrike();
					}
					totalRuns += runs;
				}

				if (balls % 6 == 0) {
					rotateStrike();
				}

				currentStatus = getCurrentStatus();
			}

			displayMatchResult();
			displayScoreCard();
			displayCommentory();
		} finally {

		}

	}

	private Status getCurrentStatus() {
		if (balls <= maxBalls) {
			if (totalRuns >= target) {
				return Status.WIN;
			}
			return Status.IN_PROGRESS;
		}

		return Status.LOSS;
	}

	private enum Status {
		WIN, LOSS, IN_PROGRESS
	}

	private void rotateStrike() {
		if (striker == batsman1) {
			striker = batsman2;
		} else {
			striker = batsman1;
		}
	}

	private void rotateBatsman() {
		if (striker == batsman1) {
			batsman1.setOut(true);
			batsman1 = nextBatsman();
			striker = batsman1;
		} else {
			batsman2.setOut(true);
			batsman2 = nextBatsman();
			striker = batsman2;
		}
	}

	public Batsman nextBatsman() {
		return batsmenIterator.hasNext() ? batsmenIterator.next() : null;
	}

	private void displayMatchResult() {
		final String teamName = this.team.getName();
		if (currentStatus == Status.WIN) {
			final String status = "won";
			final String parameter = String.format(winFormat, (maxWickets - wickets), (maxBalls - balls));
			final String result = String.format(resultFormat, teamName, status, parameter);

			System.out.println(result);
		} else {
			final String status = "lost";
			final String parameter = String.format(lossFormat, (target - totalRuns));
			final String result = String.format(resultFormat, teamName, status, parameter);

			System.out.println(result);
		}

	}

	private void displayScoreCard() {
		System.out.println();
		this.team.displayScoreCard();
	}

	private void displayCommentory() {
		System.out.println();
		for (Map.Entry<Integer, Strike> entry : scoreCard.entrySet()) {
			final Strike strike = entry.getValue();
			System.out.println(
					"Ball : " + entry.getKey() + " " + strike.getBatsman() + " scored " + strike.getRuns() + " runs.");
		}
	}

	private void displayCommentory2() {
		System.out.println();
		for (Map.Entry<Integer, Strike> entry : scoreCard.entrySet()) {
			final Strike strike = entry.getValue();
			System.out.println(
					"Ball : " + entry.getKey() + " " + strike.getBatsman() + " scored " + strike.getRuns() + " runs.");
		}

		// System.out.println("Wickets Fallen : " + wickets);
		// System.out.println("Batsman 1 : " + batsman1.getName());
		// System.out.println("Batsman 2: " + batsman2.getName());
	}

}
