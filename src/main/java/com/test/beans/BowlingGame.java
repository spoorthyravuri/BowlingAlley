package com.test.beans;

import java.util.ArrayList;

public class BowlingGame {
	
	private int currentPlayerIndex;
	private int totalPlayers;
	private int totalSets;
	private ArrayList<Player> players;
	
	public BowlingGame(int totalPlayers, int totalSets) {
		this.totalPlayers = totalPlayers;
		this.totalSets = totalSets;
		players = new ArrayList<Player>(totalPlayers);
	}
	
	public boolean doKnock(char knock) throws Exception {
		if(currentPlayerIndex == players.size()) {
			players.add(new Player(totalSets));
		}
		Player player = players.get(currentPlayerIndex);
		boolean doneKnock = player.doStrike(knock);
		if(doneKnock) {
			incrementCurrentPlayerIndex();
		}
		return isGameDone();
	}
	
	private void incrementCurrentPlayerIndex() {
		if(currentPlayerIndex == totalPlayers - 1) {
			currentPlayerIndex = 0;
		} else {
			currentPlayerIndex = currentPlayerIndex + 1;
		}
	}
	
	private boolean isGameDone() {
		for (Player player : players) {
			if(!player.isPlayDone()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		if(players == null) {
			return null;
		}
		StringBuilder str = new StringBuilder();
		str.append("Scoreboard:\n");
		for (int i=0; i<players.size(); i++) {
			str.append("P" + i + " : ");
			Player player = players.get(i);
			str.append(player.toString() + " -> " + player.getScore() + "\n");
		}
		return str.toString();
	}
}
