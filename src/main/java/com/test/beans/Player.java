package com.test.beans;

import java.util.ArrayList;

public class Player {
	
	private int totalSets;
	private int currentSetIndex;
	private ArrayList<BowlingSet> sets;
	private boolean isPlayDone;
	
	public Player(int totalSets) {
		this.totalSets = totalSets;
		sets = new ArrayList<BowlingSet>(totalSets - 1);
		currentSetIndex = 0;
	}
	
	public boolean doStrike(char knock) throws Exception {
		if(currentSetIndex >= totalSets) {
			throw new Exception("Invalid knock");
		} else {
			if(currentSetIndex == sets.size()) {
				sets.add(getNewBowlingSet());
			}
			BowlingSet current = sets.get(currentSetIndex);
			boolean doneRound = current.doKnock(knock);
			if(doneRound) {
				currentSetIndex++;
				if(currentSetIndex == totalSets - 1) {
					isPlayDone = true;
				}
			}
			return doneRound;
		}
	}
	
	private BowlingSet getNewBowlingSet() {
		if(currentSetIndex == totalSets - 1) {
			return new FinalBowlingSet();
		} else {
			return new InitialBowlingSet();
		}
	}
	
	public boolean isPlayDone() {
		return isPlayDone;
	}

	public int getScore() {
		int score = 0;
		if(sets != null) {
			for (BowlingSet bowlingSet : sets) {
				score = score + bowlingSet.getScore();
			}
		}
		return score;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (BowlingSet bowlingSet : sets) {
			str.append(bowlingSet.toString());
		}
		return str.toString();
	}
	
}
