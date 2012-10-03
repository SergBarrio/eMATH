package com.game.logic;

import com.measure.madness.*;

public class GameMethods {
	
	public static void updateActiveState(Star star) {
		star.setActive(true);
	}
	
	public static boolean validateQuestion(int userAnswer, int correctAnswer) {
		if (userAnswer == correctAnswer) {
			return true;
		}
		return false;
	}
	
	public static boolean validateQuestion(double userAnswer, double correctAnswer) {
		if (userAnswer == correctAnswer) {
			return true;
		}
		return false;
	}
	
	
}
