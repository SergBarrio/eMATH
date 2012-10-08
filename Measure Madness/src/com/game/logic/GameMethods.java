/*
 * This class implements an object and methods for validating and answers
 * and maintaining game logic.
 */

package com.game.logic;

import com.measure.madness.*;

public class GameMethods {
	
	private int pressedPlay = 0;
	
	
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
	
	// Check if play button is enabled
	public boolean isPlayEnabled() {
		if (pressedPlay > 3) {
			return false;
		}
		return true;
	}
	
	// Called to increment when the play button is used
	public void incrementPressedPlay() {
		pressedPlay += 1;
	}
	

}
