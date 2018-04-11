package com.test.beans;

public class InitialBowlingSet extends BowlingSet {

	private char knock1 = '\0';
	private char knock2 = '\0';
	
	private int score;
	private String display = "";

	public char getKnock1() {
		return knock1;
	}

	public char getKnock2() {
		return knock2;
	}

	private boolean doKnock1(char knock1) throws Exception {
		boolean isDone = false;
		if(knock1 == '/') {
			throw new Exception("Invalid input");
		}
		this.knock1 = knock1;
		if(knock1 == 'X') {
			score = 20;
			isDone = true;
		} else {
			score = Character.getNumericValue(knock1);
			isDone = false;
		}
		display = display + String.valueOf(knock1);
		return isDone;
	}
	
	private boolean doKnock2(char knock2) throws Exception {
		if(knock1 == '\0' || knock1 == 'X') {
			throw new Exception("Knock 2 is not permitted");
		} else {
			this.knock2 = knock2;
		}
		if(knock2 == '/') {
			score = 15;
		} else {
			score = score + Character.getNumericValue(knock2);
		}
		display = display + String.valueOf(knock2);
		return true;
	}
	
	public boolean doKnock(char knock) throws Exception {
		if(knock2 == '\0') {
			if(knock1 == '\0') {
				return doKnock1(knock);
			} else {
				return doKnock2(knock);
			}
		} else {
			throw new Exception("Invalid knock");
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public String toString() {
		return display;
	}

}
