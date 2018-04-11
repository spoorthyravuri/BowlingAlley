package com.test.game;

import com.test.beans.BowlingGame;

public class BowlingGameSimulator {
	
	public static void main(String[] args) throws Exception {
		BowlingGame bowlingGame = new BowlingGame(2, 3);
		char[] imput = {'8', '/', 'X', '5', '4', '5', '2', 'X', 'X', 'X', '8', '1'};
		for (char knock : imput) {
			boolean isGameDone = bowlingGame.doKnock(knock);
			System.out.println(bowlingGame.toString());
			if(isGameDone) {
				System.out.println("Game is done");
			}
		}
	}
	
}
