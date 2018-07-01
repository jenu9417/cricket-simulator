package com.jenu.gt.cs.main;

import java.util.LinkedList;
import java.util.List;

import com.jenu.gt.cs.bean.Batsman;
import com.jenu.gt.cs.bean.Match;
import com.jenu.gt.cs.bean.Team;

public class Main {

	private static final List<Batsman> BAT_LIST = new LinkedList<>();

	private static final int TARGET = 40;

	private static final int MAX_OVER = 4;

	private static final int MAX_WICKETS = 4;

	static {
		BAT_LIST.add(new Batsman("Kirat Boli", toArray(5, 30, 25, 10, 15, 1, 9, 5)));
		BAT_LIST.add(new Batsman("N.S.Nodhi", toArray(10, 40, 20, 5, 10, 1, 4, 10)));
		BAT_LIST.add(new Batsman("R Rumrah", toArray(20, 30, 15, 5, 5, 1, 4, 20)));
		BAT_LIST.add(new Batsman("Shashi Henra", toArray(30, 25, 5, 0, 5, 1, 4, 30)));
	}

	public static void main(String[] args) {
		final Team team = new Team("Lengaburu", BAT_LIST);
		final Match match = new Match(team, TARGET, MAX_OVER * 6, MAX_WICKETS);
		match.simulateMatch();
	}

	private static int[] toArray(int... values) {
		return values;
	}

}
