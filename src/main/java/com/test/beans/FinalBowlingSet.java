package com.test.beans;

public class FinalBowlingSet extends BowlingSet {
	
	private char knock1 = '\0';
	private char knock2 = '\0';
	private char knock3 = '\0';
	
	private int score;
	private String display = "";
	
	public char getKnock1() {
		return knock1;
	}

	public char getKnock2() {
		return knock2;
	}

	public char getKnock3() {
		return knock3;
	}
	
	private boolean doknock1(char knock1) throws Exception {
		if(knock1 == '/') {
			throw new Exception("Invalid input");
		}
		this.knock1 = knock1;
		if(knock1 == 'X') {
			score = 20;
		} else {
			score = Character.getNumericValue(knock1);
		}
		display = display + String.valueOf(knock1);
		return false;
	}

	private boolean doKnock2(char knock2) throws Exception {
		boolean isDone = false;
		if(knock1 == '\0') {
			throw new Exception("Knock 2 is not permitted");
		} else {
			this.knock2 = knock2;
		}
		if(knock2 == '/') {
			score = 15;
			isDone = true;
		} else if(knock2 == 'X') {
			score = score + 20;
			if(knock1 != 'X') {
				isDone = true;
			}
		} else {
			isDone = true;
			score = score + Character.getNumericValue(knock2);
		}
		display = display + String.valueOf(knock2);
		return isDone;
	}
	
	private boolean doKnock3(char knock3) throws Exception {
		if(knock1 != 'X' || knock2 != 'X') {
			throw new Exception("Invalid knock");
		} else {
			this.knock3 = knock3;
		}
		if(knock3 == 'X') {
			score = score + 20;
		} else {
			score = score + Character.getNumericValue(knock3);
		}
		display = display + String.valueOf(knock3);
		return true;
	}
	
	public boolean doKnock(char knock) throws Exception {
		if(knock3 == '\0') {
			if(knock2 == '\0') {
				if(knock1 == '\0') {
					return doknock1(knock);
				} else {
					return doKnock2(knock);
				}
			} else {
				return doKnock3(knock);
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
